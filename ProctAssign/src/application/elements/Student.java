package application.elements;

import java.util.List;
import java.util.ArrayList;

public class Student{

    private String name;
    private int ID;
    private List<Course> requestedCourses;
    private List<Course> coursesNotEnroledIn;
    private List<Section> courses;

    public Student(String name, int ID){
	this.name = name;
	this.ID = ID;
	this.requestedCourses = new ArrayList<Course>();
	this.coursesNotEnroledIn = new ArrayList<Course>();
	this.courses = new ArrayList<Section>();
    }

    /*Adds a request for a class if they are not taking it or havent requested it yet*/
    public boolean requestClass(Course course){
	if(!requestedCourses.contains(course) && !courses.contains(course)){
	    requestedCourses.add(course);
	    return true;
	}
	return false;
    }

    /*Adds a student to a specific section - determined by application.logic*/
   public boolean joinSection(Section section){
	if(!courses.contains(section)){
	    courses.add(section);
	    return true;
	}
	return false;
   }
}
