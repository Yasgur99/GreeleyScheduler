package application.gui;

import application.elements.Subject;
import application.elements.Teacher;
import application.logic.MasterSchedule;
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

    /*Master schedule to manage teachers*/
    private MasterSchedule schedule;
    /*To be get the string it holds*/
    private JTextField teacherName;
    /*To be get the int it holds*/
    private JTextField teacherID;
    /*0-2 is operation, 3-10 is subject,11 is boolean chair*/
    private JRadioButton[] radios;
    /*Set buttons to false upon action*/
    private ButtonGroup subjectButtons;
    /*Set boolean button to false*/
    private JRadioButton chairButtons;

    public TeacherListener(JTextField teacherName, JTextField teacherID,
            MasterSchedule schedule, JRadioButton[] radios, ButtonGroup subjectButtons, JRadioButton chairButtons) {
        this.teacherName = teacherName;
        this.teacherID = teacherID;
        this.schedule = schedule;
        this.radios = radios;
        this.subjectButtons = subjectButtons;
        this.chairButtons = chairButtons;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*Set subject of course*/
        Subject subject = setSubject();
        if(subject == null){
            JOptionPane.showMessageDialog(new JFrame(), "Error: Invalid subject selection");
            return;
        }

        /*Set coursename*/
        String teacherName = this.teacherName.getText();

        /*Parse courseID to integer if possible*/
        int teacherID;
        try {
            teacherID = Integer.parseInt(this.teacherID.getText());
        } catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Error: Invalid ID");
            return;
        }

        /*Determine if teacher is chair of their department*/
        boolean isChair = checkIfChair();

        /*Preformed specified operation*/
        if(radios[0].isSelected()){ //Add teacher
            this.schedule.addTeacher(new Teacher(subject, teacherName, teacherID, isChair));
            JOptionPane.showMessageDialog(new JFrame(), "Teacher added succesfully");
        } else if(radios[1].isSelected()){ //remove teacher
            this.schedule.removeTeacher(new Teacher(subject, teacherName, teacherID, isChair));
            JOptionPane.showMessageDialog(new JFrame(), "Teacher removed succesfully");
        } else if(radios[2].isSelected())//search teacher
            throw new UnsupportedOperationException("Still gotta implement this");
    }

    /*Determine and clear subject from button selection*/
    public Subject setSubject() {
        if(radios[3].isSelected()){
            shutOffRadios();
            return Subject.ARTS_AND_LIFE_SKILLS;
        } else if(radios[4].isSelected()){
            shutOffRadios();
            return Subject.LEARNING_CENTERS;
        } else if(radios[5].isSelected()){
            shutOffRadios();
            return Subject.MATH;
        } else if(radios[5].isSelected()){
            shutOffRadios();
            return Subject.MATH;
        } else if(radios[6].isSelected()){
            shutOffRadios();
            return Subject.SCIENCE;
        } else if(radios[7].isSelected()){
            shutOffRadios();
            return Subject.ENGLISH;
        } else if(radios[8].isSelected()){
            shutOffRadios();
            return Subject.SOCIAL_STUDIES;
        } else if(radios[9].isSelected()){
            shutOffRadios();
            return Subject.PE;
        } else if(radios[10].isSelected()){
            shutOffRadios();
            return Subject.WORLD_LANGUAGE;
        } else {
            shutOffRadios();
            return null;
        }
    }

    /*Set subject selection to nothing after checking*/
    private void shutOffRadios() {
        subjectButtons.clearSelection();
    }

    /*Determines if teacher is a chair of their department*/
    private boolean checkIfChair() {
        if(radios[11].isSelected()){
            chairButtons.setSelected(false);
            return true;
        } else
            return false;
    }
}