package application.elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author yasgur99
 *
 */
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

    public Course(Department department, int courseNumber, Semester semester, String courseName) {
        this.department = department;
        this.courseNumber = courseNumber;
        this.semester = semester;
        this.courseName = courseName;
        this.sections = new ArrayList<Section>();
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
    
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
