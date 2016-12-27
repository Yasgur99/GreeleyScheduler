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
public class DepartmentButtons extends JPanel {

    private JRadioButton[] subjectButtons;
    private ButtonGroup subjectButtonsGroup;

    public DepartmentButtons() {
        super(new GridLayout(2, 4));
        this.subjectButtonsGroup = new ButtonGroup();
        this.subjectButtons = new JRadioButton[8];
        createComponents();
    }

    /*List of radio buttons to determine subject*/
    private void createComponents() {

        JRadioButton artLife = new JRadioButton("Art/Lifeskills");
        artLife.setMnemonic(KeyEvent.VK_T);
        subjectButtons[0] = artLife;

        JRadioButton learning = new JRadioButton("Learning Centers");
        learning.setMnemonic(KeyEvent.VK_L);
        subjectButtons[1] = learning;

        JRadioButton math = new JRadioButton("Math");
        math.setMnemonic(KeyEvent.VK_M);
        subjectButtons[2] = math;

        JRadioButton science = new JRadioButton("Science");
        science.setMnemonic(KeyEvent.VK_I);
        subjectButtons[3] = science;

        JRadioButton english = new JRadioButton("English");
        english.setMnemonic(KeyEvent.VK_E);
        subjectButtons[4] = english;

        JRadioButton social = new JRadioButton("Social Studies");
        social.setMnemonic(KeyEvent.VK_U);
        subjectButtons[5] = social;

        JRadioButton pe = new JRadioButton("PE");
        pe.setMnemonic(KeyEvent.VK_P);
        subjectButtons[6] = pe;

        JRadioButton language = new JRadioButton("World Language");
        language.setMnemonic(KeyEvent.VK_N);
        subjectButtons[7] = language;

        /*Add buttons to button group*/
        subjectButtonsGroup.add(artLife);
        subjectButtonsGroup.add(learning);
        subjectButtonsGroup.add(math);
        subjectButtonsGroup.add(science);
        subjectButtonsGroup.add(english);
        subjectButtonsGroup.add(social);
        subjectButtonsGroup.add(pe);
        subjectButtonsGroup.add(language);

        //Add to button array
        subjectButtons[0] = artLife;
        subjectButtons[1] = learning;
        subjectButtons[2] = math;
        subjectButtons[3] = science;
        subjectButtons[4] = english;
        subjectButtons[5] = social;
        subjectButtons[6] = pe;
        subjectButtons[7] = language;

        /*Add buttons to this*/
        add(artLife);
        add(learning);
        add(math);
        add(science);
        add(english);
        add(social);
        add(pe);
        add(language);
    }

    public JRadioButton[] getSubjectButtons() {
        return subjectButtons;
    }

    public ButtonGroup getSubjectButtonsGroup() {
        return subjectButtonsGroup;
    }
    
    
}
