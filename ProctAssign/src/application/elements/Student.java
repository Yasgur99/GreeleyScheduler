package application.elements;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

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

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public List<Course> getRequestedCourses() {
        return requestedCourses;
    }

    public List<Course> getCoursesNotEnroledIn() {
        return coursesNotEnroledIn;
    }

    public List<Section> getCourses() {
        return courses;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + this.ID;
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
        final Student other = (Student) obj;
        if(this.ID != other.ID)
            return false;
        return true;
    }

   

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", ID=" + ID + ", requestedCourses=" + requestedCourses + ", coursesNotEnroledIn=" + coursesNotEnroledIn + ", courses=" + courses + '}';
    }
   
}
