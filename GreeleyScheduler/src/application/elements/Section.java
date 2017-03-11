package application.elements;

/**
 * This class represents a Section. A section is the object that belongs to a specific teacher and that
 * students belong to. A section belongs to a Course, but nobody belongs to a Course.
 * 
 * @author yasgur99
 * @see Course
 **/
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Section{

    /*Department course belongs to*/
    private Department department;
    /*Unique course ID*/
    private int courseNumber;
    /*Semester course meets*/
    private Semester semester;
    /*Name of course*/
    private String courseName;
    /*Max number of students course can hold*/
    private int maxNumberOfStudents;
    /*List of teachers who teach this course*/
    private List<Teacher> teachers;

    /**
     * This constructor sets the instance variables to those that are given as parameters
     * and initializes any data structures that need initializations.
     * 
     * @param department the Department this Section belongs to.
     * @param courseNumber the Course number that this Section belongs to.
     * @param semester the Semester this Section meets.
     * @param courseName the name of the Course this Section belongs to.
     * @param maxNumberOfStudents the maximum number of students allowed in this Section.
     **/
    public Section(Department department, int courseNumber, Semester semester, String courseName, int maxNumberOfStudents) {
        this.department = department;
        this.courseNumber = courseNumber;
        this.semester = semester;
        this.courseName = courseName;
        this.maxNumberOfStudents = maxNumberOfStudents;
        this.teachers = new ArrayList<Teacher>();
    }
    
    /**
     * Adds specified teacher to list of teachers.
     **/
    public void addTeacher(Teacher teacher){
        this.teachers.add(teacher);
    }

    /**
     * @return the Department this selection belongs to.
     **/
    public Department getDepartment() {
        return department;
    }

    /**
     * Sets the Department of this Section to that of the parameter <code>department</code>.
     * @param department the department this Section belongs to.
     **/
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * @return the Course number that this Section belongs to.
     **/
    public int getCourseNumber() {
        return courseNumber;
    }

    /**
     * Sets the Course number of this Section to that of the parameter <code>courseNumber</code>.
     * @param courseNumber the Course number that this section belongs to.
     **/
    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    /** 
     * @return the Semester enum that this Section is offered.
     **/
    public Semester getSemester() {
        return semester;
    }

    /**
     * Sets the Semester of this Section to that of <code>semester</code>.
     * @param semester the Semester this Section is offered.
     **/
    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    /**
     * @return the name of the course.
     **/
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets the name of the Course to that of <code>courseName</code>
     * @param courseName the name of the Course this Section belongs to.
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @return the maximum number of students allowed in this Section.
     **/
    public int getMaxNumberOfStudents() {
        return maxNumberOfStudents;
    }

    /**
     * Sets the maximum number of students allowed in this section.
     * @param maxNumberOfStudents the maximum number of students allowed in this section.
     **/
    public void setMaxNumberOfStudents(int maxNumberOfStudents) {
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    /**
     * @return a List of teachers who teach this Section.
     **/
    public List<Teacher> getTeachers() {
        return teachers;
    }

    /**
     * Replaces current List of teachers to that of <code>teachers</code>.
     * @param teachers the new List of teachers.
     **/
    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.courseNumber;
        hash = 19 * hash + Objects.hashCode(this.semester);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        final Section other = (Section) obj;
        if(this.courseNumber != other.courseNumber)
            return false;
        return true;
    }
    
    
}
