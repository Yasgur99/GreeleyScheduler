package application.gui;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * @author yasgur99
 *
 */
public class SemesterButtons extends JPanel {

    private JRadioButton[] semesterButtons;
    private ButtonGroup semesterButtonGroup;

    public SemesterButtons() {
        super(new GridLayout(1, 3));
        this.semesterButtonGroup = new ButtonGroup();
        this.semesterButtons = new JRadioButton[3];
        createComponents();
    }

    /*Create buttons and add them to */
    private void createComponents() {

        JRadioButton firstSemester = new JRadioButton("First semester");
        firstSemester.setMnemonic(KeyEvent.VK_F);
        semesterButtons[0] = firstSemester;

        JRadioButton secondSemester = new JRadioButton("Second semester");
        secondSemester.setMnemonic(KeyEvent.VK_S);
        semesterButtons[1] = secondSemester;

        JRadioButton bothSemesters = new JRadioButton("Both semesters");
        bothSemesters.setMnemonic(KeyEvent.VK_B);
        semesterButtons[2] = bothSemesters;

        //Add to button group
        semesterButtonGroup.add(firstSemester);
        semesterButtonGroup.add(secondSemester);
        semesterButtonGroup.add(bothSemesters);

        //Add to button array
        semesterButtons[0] = firstSemester;
        semesterButtons[1] = secondSemester;
        semesterButtons[2] = bothSemesters;

        //Add to this JPanel
        add(firstSemester);
        add(secondSemester);
        add(bothSemesters);
    }

    public JRadioButton[] getSemesterButtons() {
        return semesterButtons;
    }

    public ButtonGroup getSemesterButtonGroup() {
        return semesterButtonGroup;
    }
    
    
}
