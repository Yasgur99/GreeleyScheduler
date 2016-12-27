package application.elements;

/**
 * @author yasgur99
 *
 */
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

    public Section(Department department, int courseNumber, Semester semester, String courseName, int maxNumberOfStudents) {
        this.department = department;
        this.courseNumber = courseNumber;
        this.semester = semester;
        this.courseName = courseName;
        this.maxNumberOfStudents = maxNumberOfStudents;
        this.teachers = new ArrayList<Teacher>();
    }
    
    /*Adds specified teacher to list of teacher*/
    public void addTeacher(Teacher teacher){
        this.teachers.add(teacher);
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

    public int getMaxNumberOfStudents() {
        return maxNumberOfStudents;
    }

    public void setMaxNumberOfStudents(int maxNumberOfStudents) {
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

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
