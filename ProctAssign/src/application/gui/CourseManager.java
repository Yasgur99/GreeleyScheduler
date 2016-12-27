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
public class CourseManager extends JPanel {

    /*0-2 is opeation, 3-10 is subject buttons*/
    private JRadioButton[] radios;
    /*course name to be converted to string by listener*/
    private JTextField courseName;
    /*Course ID to be paresed to in by listener*/
    private JTextField courseID;
    /*Master schedule to be given to listerner to complete operation*/
    private MasterSchedule schedule;
    /*Subject buttons to be turned off by listener*/
    private ButtonGroup subjectButtons;

    public CourseManager(MasterSchedule schedule) {
        super(new BorderLayout());
        this.schedule = schedule;
        this.courseName = new JTextField();
        this.courseID = new JTextField();
        radios = new JRadioButton[11];
        createComponents();
    }

    private void createComponents() {
        /*Create add/remove radio buttons*/
        add(createOperationButtons(), BorderLayout.NORTH);

        /*Create required fields to add element*/
        add(createTextFields(), BorderLayout.WEST);

        /*Create button that does operation*/
        add(createGoButton(), BorderLayout.SOUTH);

        /*Create a scroll field that shows students - needs to be implemented*/
        add(new CourseList(schedule));
    }

    private JPanel createOperationButtons() {
        /*create add, remove, and search buttons*/
        JPanel buttons = new JPanel(new GridLayout(3, 1));

        JRadioButton add = new JRadioButton("Add course");
        add.setMnemonic(KeyEvent.VK_A);
        radios[0] = add;

        JRadioButton remove = new JRadioButton("Remove course");
        remove.setMnemonic(KeyEvent.VK_R);
        radios[1] = remove;

        JRadioButton search = new JRadioButton("Search course");
        search.setMnemonic(KeyEvent.VK_S);
        radios[2] = search;

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(add);
        buttonGroup1.add(remove);
        buttonGroup1.add(search);

        buttons.add(add);
        buttons.add(remove);
        buttons.add(search);

        return buttons;
    }

    private JPanel createTextFields() {
        /*Create fields to be used to do operation by listener*/
        JPanel input = new JPanel(new GridLayout(5, 2));
        input.add(new JLabel("Subject: "));
        input.add(createSubjectButtons());
        input.add(new JLabel("Course Name:"));
        input.add(this.courseName);
        input.add(new JLabel("Course ID: "));
        input.add(this.courseID);
        return input;
    }

    /*create go button that submits fields to listener and does operation*/
    private JButton createGoButton() {
        JButton go = new JButton("Go");
        go.addActionListener(new CourseListener(courseName, courseID, schedule, radios, subjectButtons));
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
    
 
    
}