package application.gui;

import application.gui.coursestuff.CourseManager;
import application.gui.teacherstuff.TeacherManager;
import java.awt.GridLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * @author yasgur99
 *
 */
public class MyTabbedPane extends JPanel {

    /*Tabbed pane to hold course,teacher,student,and schedule panels*/
    private JTabbedPane tabbedPane;

    public MyTabbedPane() {
        super(new GridLayout(1, 1));
        this.tabbedPane = new JTabbedPane();
        createComponents();
    }

    private void createComponents() {
        /*Add courses tab and its panel manager*/
        JComponent courses = new CourseManager();
        tabbedPane.addTab("Courses", courses);

        /*Add teacher tab and its panel manager*/
        JComponent teachers = new TeacherManager();
        tabbedPane.addTab("Teachers", teachers);

        /*Add students tab and its panel manager*/
        JComponent students = makeTextPanel("To be implemented");
        //JComponent students = new CourseManager(schedule);
        tabbedPane.addTab("Students", students);

        /*to be implemented further*/
        JComponent schedule = makeTextPanel("To be implemented");
        tabbedPane.addTab("Schedule", schedule);

        /*add to this JPanel*/
        add(tabbedPane);
    }

    /*Method that returns a title for the tab*/
    private JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
}
