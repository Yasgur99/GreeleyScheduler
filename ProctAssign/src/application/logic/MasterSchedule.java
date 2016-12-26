package application.logic;

import application.elements.Course;
import application.elements.Student;
import application.elements.Teacher;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yasgur99
 **/

public class MasterSchedule {

    private List<Teacher> teachers;
    private List<Course> courses;
    private List<Student> students;
    
    public MasterSchedule(List<Teacher> teachers, List<Course> courses, List<Student> students){
        this.teachers = teachers;
        this.courses = courses;
        this.students = students;
    }
    
    public MasterSchedule(){
        this(new ArrayList<Teacher>(), new ArrayList<Course>(), new ArrayList<Student>());
    }
    
    public void addTeacher(Teacher teacher){
        if(!teachers.contains(teacher))
            teachers.add(teacher);
    }
    
    public void addCourse(Course course){
         if(!courses.contains(course))
            courses.add(course);
    }
    
    public void addStudent(Student student){
         if(!students.contains(student))
            students.add(student);
    }
    
    public void removeTeacher(Teacher teacher){
        teachers.remove(teacher);
    }
    
    public void removeCourse(Course course){
        courses.remove(course);
    }
    
    public void removeStudent(Student student){
        students.remove(student);
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Student> getStudents() {
        return students;
    }
    
    
}
