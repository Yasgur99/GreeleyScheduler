package application.elements;

/**
 * This class represents a Course. A Course is the curriculum that is offered, but nobody belongs to a 
 * Course. Instead, a Course holds a List of the Sections that belong to the Course. The Course
 * has information that can be used to identify it, and its primary function in this program
 * is so we can add Teachers and Sections to a common data structure. It has no function in the
 * genetic algorithm and is used mainly for parsing in the Teachers and what Sections they teach.
 * 
 * @author yasgur99
 * @see Section
 * @see Teacher
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course {

    /*Department course belongs to*/
    private Department department;
    /*Unique course ID*/
    private int courseNumber;
    /*Semester course meets*/
    private Semester semester;
    /*Name of course*/
    private String courseName;
    /*List of sections of this course type*/
    private List<Section> sections;

    /**
     * This constructor sets the instance variables to those that are given as parameters
     * and initializes any data structures that need initialization
     * 
     * @param department the Department that this Course belongs to
     * @param courseNumber the number of this Course
     * @param semester the Semester that this Course is offered
     * @param courseName the name of this Course
     **/
    public Course(Department department, int courseNumber, Semester semester, String courseName) {
        this.department = department;
        this.courseNumber = courseNumber;
        this.semester = semester;
        this.courseName = courseName;
        this.sections = new ArrayList<Section>();
    }
    
    /**
     * @return the Department that this Course belongs to.
     * @see Department
     **/
    public Department getDepartment() {
        return department;
    }

    /**
     * Sets the Department of this Course to that of <code>department</code>.
     * @param department the Department this Course belongs to.
     * @see Department
     **/
    public void setDepartment(Department department) {
        this.department = department;
    }

    /** 
     * @return the course number of this Course
     **/
    public int getCourseNumber() {
        return courseNumber;
    }

    /**
     * Sets the number of this Course to that of <code>courseNumber</code>.
     * @param courseNumber the number used to identify this course.
     **/
    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    /** 
     * @return the Semester that this Course meets.
     * @see Semester
     **/
    public Semester getSemester() {
        return semester;
    }

    /**
     * Sets the Semester of this Course to that of <code>semester</code>.
     * @param semester the Semester this Course meets.
     * @see Semester
     **/
    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    /**
     * @return the name of this Course.
     **/
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets the name of this Course to that of <code>courseName</code>.
     * @param courseName the name of this Course 
     **/
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @return a List of the Sections of this Course.
     **/
    public List<Section> getSections() {
        return sections;
    }

    /**
     * Replaces the current List of Sections that meet to that of <code>sections</code>.
     * @param sections the new List of sections that belongs to this Course. 
     * @see Section
     **/
    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
    
    /**
     * @return the number of Sections of this Course.
     * @see Section
     **/
    public int getNumberOfSections(){
        return this.sections.size();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.courseNumber;
        hash = 79 * hash + Objects.hashCode(this.semester);
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
        final Course other = (Course) obj;
        if(this.courseNumber != other.courseNumber)
            return false;
        return true;
    }
}