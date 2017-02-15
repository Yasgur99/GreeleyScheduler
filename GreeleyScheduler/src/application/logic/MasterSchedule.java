package application.logic;

import application.elements.Course;
import application.elements.Teacher;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yasgur99
 **/

public class MasterSchedule {

    private List<Teacher> teachers;
    private List<Course> courses;
    
    public MasterSchedule(List<Teacher> teachers, List<Course> courses){
        this.teachers = teachers;
        this.courses = courses;
    }
    
    public MasterSchedule(){
        this(new ArrayList<Teacher>(), new ArrayList<Course>());
    }
    
    public void addTeacher(Teacher teacher){
        if(!teachers.contains(teacher))
            teachers.add(teacher);
    }
    
    public void addCourse(Course course){
         if(!courses.contains(course))
            courses.add(course);
    }
  
    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Course> getCourses() {
        return courses;
    }
}