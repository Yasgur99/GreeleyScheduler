package application.gui.coursestuff;

import application.gui.DepartmentButtons;
import application.gui.OperationButtons;
import application.gui.SemesterButtons;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * @author yasgur99
 *
 */
public class CourseManager extends JPanel {

    /*Course name to be parsed by listener*/
    private JTextField courseName;
    /*Course ID to be paresed by listener*/
    private JTextField courseID;
    /*JPanel containing a group of radio buttons of avaliable departments*/
    private DepartmentButtons departmentButtons;
    /*JPanel containing a group of radio buttons of avaliable semesters*/
    private SemesterButtons semesterButtons;

    public CourseManager() {
        super(new BorderLayout());
        this.courseName = new JTextField();
        this.courseID = new JTextField();
        createComponents();
    }

    private void createComponents() {
        /*Create add/remove radio buttons*/
        add(new OperationButtons("course"), BorderLayout.NORTH);

        /*Create required fields to add element*/
        add(createTextFields(), BorderLayout.WEST);

        /*Create button that does operation*/
        add(createGoButton(), BorderLayout.SOUTH);

        /*Create a scroll field that shows students - needs to be implemented*/
    }

    private JPanel createTextFields() {
        /*Create fields to be used to do operation by listener*/
        JPanel input = new JPanel(new GridLayout(8,1));
        input.add(new JLabel("Subject: "));
        input.add(new DepartmentButtons());
        input.add(new JLabel("Semester: "));
        input.add(new SemesterButtons());
        input.add(new JLabel("Course Name:"));
        input.add(this.courseName);
        input.add(new JLabel("Course ID: "));
        input.add(this.courseID);
        return input;
    }

    /*create go button that submits fields to listener and does operation*/
    private JButton createGoButton() {
        JButton go = new JButton("Go");
        //go.addActionListener(new CourseListener(courseName, courseID, schedule, radios, subjectButtons));
        return go;
    }
}
