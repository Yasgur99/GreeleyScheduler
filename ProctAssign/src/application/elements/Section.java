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

    /*Sets the teacher for this section - in the future might be changed to accomidate multiple teachers in one class*/
    public void setTeacher(Teacher teacher){
	this.teacher = teacher;
    }

    /*Returns teacher of this section*/
    public Teacher getTeacher(){
	return teacher;
    }

    /*Sets the course number - is determined in application.logic*/
    public void setCourseNum(int courseNum){
	this.courseNum = courseNum;
    }

    /*returns the course (1-8) that this class meets*/
    public int getCourseNum(){
	return courseNum;
    }
    
    /*returns the course (ie. Math, Science, Social Studies, etc.*/
    public Course getCourse(){
        return this.course;
    }

    /*Adds a student if there is room*/
    public boolean addStudent(Student student){
        if(students.size() < course.getMaxStudentAmount() && !students.contains(student)){
	    students.add(student);
	    return true;
        }
        return false;
    }
    

    /*removes specified student*/
    public boolean removeStudent(Student student){
	return students.remove(student);
    }

    /*Returns a list of students in this section*/
    public List<Student> getStudents(){
	return students;
    }
}