package application.gui;

import application.logic.MasterSchedule;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * @author yasgur99
 *
 */
public class TeacherManager extends JPanel {

    /*0-2 is operation, 3-10 is subject,11 is boolean chair*/
    private JRadioButton[] radios;
    /*JTextField to hold teacher name and give to listener*/
    private JTextField teacherName;
    /*JTextField to hold id to give to listener*/
    private JTextField teacherID;
    /*Master schedule to give to listener*/
    private MasterSchedule schedule;
    /*Subject radio buttons to give listener to clear selection*/
    private ButtonGroup subjectButtons;
    /*Chair boolean radio button to give listener to clear selection*/
    private JRadioButton chairButton;

    public TeacherManager(MasterSchedule schedule) {
        super(new BorderLayout());
        this.schedule = schedule;
        this.teacherName = new JTextField();
        this.teacherID = new JTextField();
        radios = new JRadioButton[12];
        createComponents();
    }

    private void createComponents() {
        /*Create add/remove radio buttons*/
        add(createOperationButtons(), BorderLayout.NORTH);

        /*Create required fields to add element*/
        add(createTextFields(), BorderLayout.WEST);

        /*Create button that does operation*/
        add(createGoButton(), BorderLayout.SOUTH);

        /*Create a scroll field that shows students - need to implement*/
    }

    private JPanel createOperationButtons() {
        /*Create add remove, and search buttons*/
        JPanel buttons = new JPanel(new GridLayout(3, 1));

        JRadioButton add = new JRadioButton("Add teacher");
        add.setMnemonic(KeyEvent.VK_A);
        radios[0] = add;

        JRadioButton remove = new JRadioButton("Remove teacher");
        remove.setMnemonic(KeyEvent.VK_R);
        radios[1] = remove;

        JRadioButton search = new JRadioButton("Search teacher");
        search.setMnemonic(KeyEvent.VK_S);
        radios[2] = search;

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(add);
        buttonGroup.add(remove);
        buttonGroup.add(search);

        buttons.add(add);
        buttons.add(remove);
        buttons.add(search);

        return buttons;
    }

    private JPanel createTextFields() {
        /*Create fields for user to input information about teacher object */
        JPanel input = new JPanel(new GridLayout(4, 2));
        input.add(new JLabel("Subject: "));
        input.add(createSubjectButtons());
        input.add(new JLabel("Teacher Name:"));
        input.add(this.teacherName);
        input.add(new JLabel("Teacher ID: "));
        input.add(this.teacherID);
        input.add(createIsChair());
        return input;
    }

    /*Go button that submitis fields to listeners to complete opeation*/
    private JButton createGoButton() {
        JButton go = new JButton("Go");
        go.addActionListener(new TeacherListener(teacherName, teacherID, schedule, radios, subjectButtons, chairButton));
        return go;
    }

    /*List of radio buttons to determine subject*/
    private JPanel createSubjectButtons() {
        JPanel buttons = new JPanel(new GridLayout(4, 2));

        JRadioButton artLife = new JRadioButton("Art/Lifeskills");
        artLife.setMnemonic(KeyEvent.VK_T);
        radios[3] = artLife;

        JRadioButton learning = new JRadioButton("Learning Centers");
        learning.setMnemonic(KeyEvent.VK_L);
        radios[4] = learning;

        JRadioButton math = new JRadioButton("Math");
        math.setMnemonic(KeyEvent.VK_M);
        radios[5] = math;

        JRadioButton science = new JRadioButton("Science");
        science.setMnemonic(KeyEvent.VK_I);
        radios[6] = science;

        JRadioButton english = new JRadioButton("English");
        english.setMnemonic(KeyEvent.VK_E);
        radios[7] = english;

        JRadioButton social = new JRadioButton("Social Studies");
        social.setMnemonic(KeyEvent.VK_U);
        radios[8] = social;

        JRadioButton pe = new JRadioButton("PE");
        pe.setMnemonic(KeyEvent.VK_P);
        radios[9] = pe;

        JRadioButton language = new JRadioButton("World Language");
        language.setMnemonic(KeyEvent.VK_N);
        radios[10] = language;

        subjectButtons = new ButtonGroup();
        subjectButtons.add(artLife);
        subjectButtons.add(learning);
        subjectButtons.add(math);
        subjectButtons.add(science);
        subjectButtons.add(english);
        subjectButtons.add(social);
        subjectButtons.add(pe);
        subjectButtons.add(language);

        buttons.add(artLife);
        buttons.add(learning);
        buttons.add(math);
        buttons.add(science);
        buttons.add(english);
        buttons.add(social);
        buttons.add(pe);
        buttons.add(language);

        return buttons;
    }

    /*Create isChair boolean radio button*/
    public JPanel createIsChair() {
        JPanel button = new JPanel(new GridLayout(1, 1));

        chairButton = new JRadioButton("Check only if teacher is department chair");
        chairButton.setMnemonic(KeyEvent.VK_C);
        radios[11] = chairButton;

        button.add(chairButton);

        return button;
    }
}
