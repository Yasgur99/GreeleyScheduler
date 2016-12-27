package application.gui.coursestuff;

import application.elements.Department;
import application.elements.Semester;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * @author yasgur99
 *
 */
public class CourseListener implements ActionListener {

    private JRadioButton[] operationButtons;
    private ButtonGroup operationButtonGroup;
    private JRadioButton[] departmentButtons;
    private ButtonGroup departmentButtonGroup;
    private JRadioButton[] semesterButtons;
    private ButtonGroup semesterButtonGroup;
    private JTextField courseNameField;
    private JTextField courseIDField;

    public CourseListener(JRadioButton[] operationButtons, ButtonGroup operationButtonGroup,
            JRadioButton[] departmentButtons, ButtonGroup departmentButtonGroup,
            JRadioButton[] semesterButtons, ButtonGroup semesterButtonGroup,
            JTextField courseNameField, JTextField courseIDField) {
        this.operationButtons = operationButtons;
        this.operationButtonGroup = operationButtonGroup;
        this.departmentButtons = departmentButtons;
        this.departmentButtonGroup = departmentButtonGroup;
        this.semesterButtons = semesterButtons;
        this.semesterButtonGroup = semesterButtonGroup;
        this.courseNameField = courseNameField;
        this.courseIDField = courseIDField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*Set and validate department*/
        Department department = determineDepartment();
        if(department == null){
            JOptionPane.showMessageDialog(new JFrame(), "Error: Invalid department selection");
            return;
        }

        /*Set and validate semester*/
        Semester semester = determineSemester();
        if(semester == null){
            JOptionPane.showMessageDialog(new JFrame(), "Error: Invalid semester selection");
            return;
        }

        /*Set and validate courseName*/
        String courseName = this.courseNameField.getText();
        if(courseName.equals("")){
            JOptionPane.showMessageDialog(new JFrame(), "Error: Course name is empty");
            return;
        }

        /*Set and validate courseID*/
        int courseID;
        try {
            courseID = Integer.parseInt(this.courseIDField.getText());
        } catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Error: Invalid ID format");
            return;
        }

        /*Complete operation if allowed*/
        if(operationButtons[0].isSelected())
            addCourse(department, semester, courseName, courseID);
        else if(operationButtons[1].isSelected())
            removeCourse(department, semester, courseName, courseID);
        else{
            JOptionPane.showMessageDialog(new JFrame(), "Error: Invalid operation selection");
            return;
        }

        /*Clear selections (except operation because that will probalby stay common)*/
        departmentButtonGroup.clearSelection();
        semesterButtonGroup.clearSelection();
        courseNameField.setText("");
        courseIDField.setText("");
    }

    public void addCourse(Department department, Semester semester, String courseName, int courseID) {

        // rest is to be implemented
    }

    public void removeCourse(Department department, Semester semester, String courseName, int courseID) {

        //rest is to be implemented
    }

    /*set and clear subject*/
    public Department determineDepartment() {
        if(departmentButtons[0].isSelected())
            return Department.ARTS_AND_LIFE_SKILLS;
        else if(departmentButtons[1].isSelected())
            return Department.LEARNING_CENTERS;
        else if(departmentButtons[2].isSelected())
            return Department.MATH;
        else if(departmentButtons[3].isSelected())
            return Department.SCIENCE;
        else if(departmentButtons[4].isSelected())
            return Department.ENGLISH;
        else if(departmentButtons[5].isSelected())
            return Department.SOCIAL_STUDIES;
        else if(departmentButtons[6].isSelected())
            return Department.PE;
        else if(departmentButtons[7].isSelected())
            return Department.WORLD_LANGUAGE;
        else
            return null;
    }

    public Semester determineSemester() {
        if(semesterButtons[0].isSelected())
            return Semester.SEMESTER_1;
        else if(semesterButtons[1].isSelected())
            return Semester.SEMESTER_2;
        else if(semesterButtons[2].isSelected())
            return Semester.BOTH_SEMESTERS;
        else
            return null;
    }
}
