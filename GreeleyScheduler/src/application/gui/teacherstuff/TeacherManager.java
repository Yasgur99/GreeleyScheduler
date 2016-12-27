package application.gui.teacherstuff;

import application.gui.DepartmentButtons;
import application.gui.OperationButtons;
import application.gui.SemesterButtons;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author yasgur99
 *
 */
public class TeacherManager extends JPanel {

    /*Teacher name to be parsed by listener*/
    private JTextField teacherName;
    /*JPanel containing a group of radio buttons of avaliable opeartions*/
    private OperationButtons operationButtons;
    /*JPanel containing a group of radio buttons of avaliable departments*/
    private DepartmentButtons departmentButtons;

    public TeacherManager() {
        super(new BorderLayout());
        this.teacherName = new JTextField();
        createComponents();
    }

    private void createComponents() {
        /*Create add/remove radio buttons*/
        this.operationButtons = new OperationButtons("teacher");
        add(operationButtons, BorderLayout.NORTH);

        /*Create required fields to add element*/
        add(createTextFields(), BorderLayout.WEST);

        /*Create button that does operation*/
        add(createGoButton(), BorderLayout.SOUTH);

        /*Create a scroll field that shows students - needs to be implemented*/
    }

    private JPanel createTextFields() {
        /*Create fields to be used to do operation by listener*/
        JPanel input = new JPanel(new GridLayout(4, 1));
        input.add(new JLabel("Subject: "));
        this.departmentButtons = new DepartmentButtons();
        input.add(this.departmentButtons);
        input.add(new JLabel("Teacher Name:"));
        input.add(this.teacherName);
        return input;
    }

    /*create go button that submits fields to listener and does operation*/
    private JButton createGoButton() {
        JButton go = new JButton("Go");
        go.addActionListener(new TeacherListener(operationButtons.getOperationButtons(), operationButtons.getOperationButtonGroup(),
                departmentButtons.getSubjectButtons(), departmentButtons.getSubjectButtonsGroup(),teacherName));
        return go;
    }

}
