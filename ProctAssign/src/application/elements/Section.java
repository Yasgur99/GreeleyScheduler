package application.elements;

import java.util.List;
import java.util.ArrayList;

public class Section{
    
    private Course course;
    private Teacher teacher;
    private int courseNum;
    private List<Student> students;

    public Section(int possibleStudentAmount){
	this.students = new ArrayList<Student>();
    }

    public void setTeacher(Teacher teacher){
	this.teacher = teacher;
    }

    public Teacher getTeacher(){
	return teacher;
    }

    public void setCourseNum(int courseNum){
	this.courseNum = courseNum;
    }

    public int getCourseNum(){
	return courseNum;
    }

    public boolean addStudent(Student student){
        if(students.size() < course.getMaxStudents() && !students.contains(student)){
	    students.add(student);
	    return true;
        }
        return false;
    }

    public boolean removeStudent(Student student){
	return students.remove(student);
    }

    public List<Student> getStudents(){
	return students;
    }
}
