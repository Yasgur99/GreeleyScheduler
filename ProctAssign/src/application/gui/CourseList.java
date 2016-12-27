package application.gui;

import application.elements.Course;
import application.logic.MasterSchedule;
import java.util.List;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * @author yasgur99
 *
 */
public class CourseList extends JPanel {

    private MasterSchedule schedule;

    public CourseList(MasterSchedule schedule) {
        super();
        this.schedule = schedule;
        createComponents();
    }

    public void createComponents() {
        Object[] arr = schedule.getCourses().toArray();
        JList<Course> courses = new JList(arr);
        JScrollPane scrollPane = new JScrollPane(courses);
        scrollPane.getViewport().setView(courses);
        add(scrollPane);
    }
}
