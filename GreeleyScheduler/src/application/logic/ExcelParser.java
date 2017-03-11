package application.logic;

/**
 * @author michaelmaitland
 */
import application.elements.Course;
import application.elements.Department;
import application.elements.Semester;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelParser {

    /*Filenames of excel spredsheats that contain each departments info*/
    private String[] filenames;
    /*List of all courses at Greeley*/
    private Map<Integer, Course> courseMap;

    public ExcelParser(String[] filenames) {
        this.filenames = filenames;
        this.courseMap = new HashMap<>();
        //Load all documents
        for (int fileNum = 0; fileNum < this.filenames.length; fileNum++)
            loadDoc(fileNum);
    }

    private void loadDoc(int fileNum) {
        FileInputStream fis = null;
        XSSFWorkbook workbook = null;
        try {
            /*Create File and get its input stream*/
            File file = new File(filenames[fileNum]);
            fis = new FileInputStream(file);

            /*Get an instance of the workbook*/
            workbook = new XSSFWorkbook(fis);

            /*For all sheets in the workbook, get and look at them one by one*/
            int numOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numOfSheets; i++) {
                XSSFSheet sheet = workbook.getSheetAt(i);

                /*Determine which type of sheet we have and parse accordingly*/
                if (sheet.getSheetName().trim().equals("Master Schedule Projections"))
                    parseCourses(sheet);
                else if (sheet.getSheetName().trim().equals("Teacher AssignmentsConstraints"))
                    parseTeacherConstraints(sheet);
                else
                    System.out.println("[!!]Page title not formatted correctly[!!]\n"
                            + "Make sure that excel pages"
                            + "are in the form \"Master Schedule Projections\" or"
                            + " \"Teacher AssignmentsConstraints\"");
            }
        } catch (FileNotFoundException fnofex) {
            System.out.println("File not found");
        } catch (IOException ioex) {
            System.out.println("IOException creating FileInputStream or new File");
        } finally {
            try {
                /*close resources*/
                if (fis != null) fis.close();
                if (workbook != null) workbook.close();
            } catch (IOException ioex) {
                System.out.println("IOException closing resources");
            }
        }
    }

    /*Global variables to be used to create courses*/
    private int courseNum;
    private Semester semester;
    private String courseName;
    private boolean cellParsed = false;

    private void parseCourses(XSSFSheet sheet) {
        /*Determine subject on document*/
        Department department = determineSubject(sheet);
        if (department == Department.N_A)
            throw new IllegalArgumentException("Excel sheet not formated with correct department on first line");

        /*Get iterator to all the rows in current sheet and traverse row*/
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            /*Check if this row contains the options (aka header)*/
            if (row.getRowNum() == 3) continue;

            /*Traverse each column in current row*/
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                if (cell.getColumnIndex() < 7 || cell.getColumnIndex() > 12) continue; // dont need previous year

                /*Parse cell and set data if that cell contains anything we want*/
                parseCell(cell);
            }
            /*If this row contained information for a course, add it to the map*/
            if (cellParsed && courseNum != -1)
                courseMap.put(courseNum, new Course(department, courseNum, semester, courseName));
            cellParsed = false;
            courseNum = -1;
        }
    }

    private Department determineSubject(XSSFSheet sheet) {
        /*Determine subject of sheet*/
        int firstRowNum = sheet.getFirstRowNum();
        Row firstRow = sheet.getRow(firstRowNum);

        /*Check to make sure firstRow isn't null*/
        if (firstRow == null) return Department.N_A;

        /*Get first cell of first row*/
        int firstCellNum = firstRow.getFirstCellNum();
        Cell firstCell = firstRow.getCell(firstCellNum);

        /*Check to make sure firstCell isn't null*/
        if (firstCell == null) return Department.N_A;

        /*Check to make sure that cell contains a String*/
        if (firstCell.getCellTypeEnum() == CellType.STRING)
            /*check to make sure that we are looking at a cell that is formatted correctly*/
            if (firstCell.getStringCellValue()
                    .matches("\\d\\d\\d\\d-\\d\\d\\d\\d Master Schedule Projections - (.)*"))
                return determineSubject(firstCell.getStringCellValue());

        /*We couldn't find a match - this N_A will be checked above and exception thrown*/
        return Department.N_A;
    }

    private Department determineSubject(String cellValue) {
        if (cellValue.contains("Art & Life Department")) return Department.ART_AND_LIFESKILLS;
        else if (cellValue.contains("English Department")) return Department.ENGLISH;
        else if (cellValue.contains("Life School")) return Department.LIFE_SCHOOL;
        else if (cellValue.contains("Math Department")) return Department.MATHEMATICS;
        else if (cellValue.contains("Performing Arts Department")) return Department.PREFORMING_ARTS;
        else if (cellValue.contains("Physical Education Department")) return Department.PHYSICAL_EDUCATION;
        else if (cellValue.contains("Science Department")) return Department.SCIENCE;
        else if (cellValue.contains("Social Studies Department")) return Department.SOCIAL_STUDIES;
        else if (cellValue.contains("Special Ed Department")) return Department.SPECIAL_EDUCATION;
        else if (cellValue.contains("World Language Department")) return Department.WORLD_LANGUAGE;
        else return Department.N_A;
    }

    private void parseCell(Cell cell) {
        int columnIndex = cell.getColumnIndex();

        /*Check if we are in column that contains course names*/
        if (columnIndex == 8) {
            /*Check for correct formatting*/
            if (cell.getCellTypeEnum() == CellType.STRING) {
                String cellVal = cell.getStringCellValue();
                courseName = cellVal;
                /*Determine semester via the name of the course*/
                if (cellVal.contains("(F)")) {
                    semester = Semester.SEMESTER_1;
                } else if (cellVal.contains("(S)")) {
                    semester = Semester.SEMESTER_2;
                } else {
                    semester = Semester.BOTH_SEMESTERS;
                }
                /*If we have set the semester and the name then we are good to go*/
                cellParsed = true;
            }
            /*Check if we are in column that contains course numbers*/
        } else if (columnIndex == 7) {
            if (cell.getCellTypeEnum() == CellType.NUMERIC) {
                int cellVal = (int) cell.getNumericCellValue();
                courseNum = cellVal;
            }
        }
    }

    /* private void parseTeacherConstraints(XSSFSheet sheet) {
        // Get iterator to all the rows in current sheet  and traverse
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            //Traverse each column in current row
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                if(cell.getCellTypeEnum() == CellType.STRING){
                    System.out.println(cell.getStringCellValue());
                }
            }
        }
    }*/
    
    /*Global variables to be used to create teachers*/
    private String teacherName;
    private List<String> sections;
    private List<String> constraints;
    private boolean isChair;

    private void parseTeacherConstraints(XSSFSheet sheet) {
        for (int i = 0; i < 40; i++) { //loop columns
            for (int j = 0; j < sheet.getLastRowNum() + 1; j++) {
                Cell cell = sheet.getRow(j).getCell(i);
                /*Check if we are done parsing sheet*/
                if (cell == null){
                    System.out.println("hi");
                    break;
                }
                /*All cells we are interested in should be of type String*/
                if (cell.getCellTypeEnum() == CellType.STRING) {
                    String cellVal = cell.getStringCellValue().trim();
                    System.out.println(cellVal);
                    
                    /*If we reach a new teacher, setup*/
                    if (cellVal.matches("[A-Z]([a-z]*), (.)*")) {
                        teacherName = cellVal;
                        isChair = false;
                        sections = new ArrayList<String>();
                        constraints = new ArrayList<String>();
                    } else if (cellVal.startsWith("C: ")) {
                        if (cellVal.equals("Chair"))
                            isChair = true;
                        else
                            sections.add(cellVal);
                    } //else
                      //  constraints.add(cellVal);
                }

            }
        }
    }
}
