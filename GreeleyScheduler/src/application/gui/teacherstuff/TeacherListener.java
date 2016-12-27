package application.gui.teacherstuff;

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
public class TeacherListener implements ActionListener {

    private JRadioButton[] operationButtons;
    private ButtonGroup operationButtonGroup;
    private JRadioButton[] departmentButtons;
    private ButtonGroup departmentButtonGroup;
    private JTextField teacherNameField;

    public TeacherListener(JRadioButton[] operationButtons, ButtonGroup operationButtonGroup,
            JRadioButton[] departmentButtons, ButtonGroup departmentButtonGroup, JTextField teacherNameField) {
        this.operationButtons = operationButtons;
        this.operationButtonGroup = operationButtonGroup;
        this.departmentButtons = departmentButtons;
        this.departmentButtonGroup = departmentButtonGroup;
        this.teacherNameField = teacherNameField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*Set and validate department*/
        Department department = determineDepartment();
        if(department == null){
            JOptionPane.showMessageDialog(new JFrame(), "Error: Invalid department selection");
            return;
        }
        
        /*Set and validate teacherName*/
        String courseName = this.teacherNameField.getText();
        if(courseName.equals("")){
            JOptionPane.showMessageDialog(new JFrame(), "Error: Teacher name is empty");
            return;
        }
        
        if(operationButtons[0].isSelected())
            addTeacher();
        else if(operationButtons[1].isSelected())
            removeTeacher();
        else{
            JOptionPane.showMessageDialog(new JFrame(), "Error: Invalid operation selection");
            return;
        }

        /*Clear selections (except operation because that will probalby stay common)*/
        departmentButtonGroup.clearSelection();
        teacherNameField.setText("");
    }

    public void addTeacher() {
       
        // rest is to be implemented
    }

    public void removeTeacher() {
        
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
}
