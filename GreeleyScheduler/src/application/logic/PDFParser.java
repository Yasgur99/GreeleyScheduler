package application.logic;

/**
 * @author michaelmaitland
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.*;
import application.elements.Subject;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFParser {

    private String filename;
    private PDDocument document;

    public PDFParser(String filename) {
        this.filename = filename;
        loadPDF();
        parse();
        closePDF();
    }

    /*Load the PDF using the filename given*/
    private void loadPDF() {
        try {
            this.document = PDDocument.load(new File(filename));
            System.out.println("Document loaded");
        } catch (IOException ex) {
            System.out.println("Incorrect path/filename");
        }
    }

    public void parse() {
        try {
            /*Put text into string*/
            PDFTextStripper pdfStripper = new PDFTextStripper();
            List<String> lines = new ArrayList<String>(Arrays.asList(
                    pdfStripper.getText(document).split("\n")));
            
            for(String line : lines) System.out.println(line);
            
            /*Convert text into lines of text*/
            StringBuilder entry = new StringBuilder();
            Subject currentSubject = null;
            /*read each line*/
            for (int i = 1; i < lines.size(); i ++) {
                /*Change current subject if needed*/
                
                evaluateIsNewSubject(lines.get(i - 1), lines.get(i), currentSubject);

                if (currentSubject == Subject.AP_EXAM) {
                    //TODO: parse AP EXAMS
                }

                if (currentSubject == Subject.GUIDANCE) {
                    //TODO: parse GUIDANCE
                }

                /*Check if line contains a Course*/
                if (lines.get(i).matches("\\d\\d\\d\\d\\s([A-Z]| |\\d)*\n")) {
                    System.out.println(lines.get(i));
                }

            }

            System.out.println("Parsing complete");
        } catch (IOException ex) {
            System.out.println("Couldnt create text stripper");
        }
    }

    public void evaluateIsNewSubject(String previousLine, String currentLine, Subject currentSubject) {
        /*
     * Check to see if previous line contains a header that indicates next
     * line might contain a subject change
         */
        if (previousLine.contains("Dept/Course/Section")) {
            /*Change currentSubject if necessary*/
            if (currentLine.contains("AP Exams")) {
                currentSubject = Subject.AP_EXAM;
            } else if (currentLine.contains("Art and Life Skills")) {
                currentSubject = Subject.ART_AND_LIFESKILLS;
            } else if (currentLine.contains("English")) {
                currentSubject = Subject.ENGLISH;
            } else if (currentLine.contains("Guidance")) {
                currentSubject = Subject.GUIDANCE;
            } else if (currentLine.contains("Life School")) {
                currentSubject = Subject.LIFE_SCHOOL;
            } else if (currentLine.contains("Mathematics")) {
                currentSubject = Subject.MATHEMATICS;
            } else if (currentLine.contains("Performing Arts")) {
                currentSubject = Subject.PREFORMING_ARTS;
            } else if (currentLine.contains("Physical Education")) {
                currentSubject = Subject.PHYSICAL_EDUCATION;
            } else if (currentLine.contains("Science")) {
                currentSubject = Subject.SCIENCE;
            } else if (currentLine.contains("Social Studies")) {
                currentSubject = Subject.SOCIAL_STUDIES;
            } else if (currentLine.contains("Special Education")) {
                currentSubject = Subject.SPECIAL_EDUCATION;
            } else if (currentLine.contains("Z-Athletics")) {
                currentSubject = Subject.ATHLETICS;
            } else if (currentLine.contains("Z-N/A")) {
                currentSubject = Subject.N_A;
            }
        }
    }

    public void closePDF() {
        try {
            this.document.close();
            System.out.println("Document closed");
        } catch (IOException ex) {
            System.out.println("Document couldn't be closed");
        }
    }

    public String getFilename() {
        return this.filename;
    }

    public PDDocument getDocument() {
        return this.document;
    }
}
