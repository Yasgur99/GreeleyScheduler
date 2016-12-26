package application.gui;

import application.elements.Course;
import application.elements.Subject;
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
public class CourseListener implements ActionListener {

    /*JTextField to be used to get string representation of courseName*/
    private JTextField courseName;
    /*JTextField to be used to get int representation of course ID*/
    private JTextField courseID;
    /*Master schedule to complete operation requested*/
    private MasterSchedule schedule;
    /*0-2 are operation, 3-10 are subjects*/
    private JRadioButton[] radios;
    /*subject buttons to be cleared*/
    private ButtonGroup subjectButtons;

    public CourseListener(JTextField courseName, JTextField courseID,
            MasterSchedule schedule, JRadioButton[] radios, ButtonGroup subjectButtons) {
        this.courseName = courseName;
        this.courseID = courseID;
        this.schedule = schedule;
        this.radios = radios;
        this.subjectButtons = subjectButtons;
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
        String courseName = this.courseName.getText();

        /*Parse courseID*/
        int courseID;
        try {
            courseID = Integer.parseInt(this.courseID.getText());
        } catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Error: Invalid ID");
            return;
        }

        /*Preformed specified operation*/
        if(radios[0].isSelected()){ //add course
            this.schedule.addCourse(new Course(subject, courseName, courseID));
            JOptionPane.showMessageDialog(new JFrame(), "Course removed succesfully");
        } else if(radios[1].isSelected()){//remove course
            this.schedule.removeCourse(new Course(subject, courseName, courseID));
            JOptionPane.showMessageDialog(new JFrame(), "Course removed succesfully");
        } else if(radios[2].isSelected())
            throw new UnsupportedOperationException("Still gotta implement this");
    }

    /*set and clear subject*/
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

    private void shutOffRadios() {
        subjectButtons.clearSelection();
    }
}
