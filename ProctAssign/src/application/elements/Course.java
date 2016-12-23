package application.elements;

import java.util.List;
import java.util.ArrayList;

public class Course{

    private Subject subject;
    private String courseName;
    private int courseID;
    private int numOfSections;
    private int maxStudentAmount;
    private int minStudentAmount;
    public List<Section> sections;

    public Course(Subject subject, String courseName, int courseID,
		 int maxStudentAmount, int minStudentAmount){
	this.subject = subject;
	this.courseName = courseName;
	this.courseID = courseID;
        this.maxStudentAmount = maxStudentAmount;
	this.minStudentAmount = minStudentAmount;
	this.sections = new ArrayList<Section>();
    }

    public void setNumOfSections(int numOfStudents){ //maybe move to logic
	this.numOfSections = 1;
    }
    
    public int getMaxStudentAmount(){
        return this.getMaxStudentAmount();
    }

    @Override
    public String toString(){
	return "Subject: " + subject + ", Course Name: " + courseName + ", Course ID: " + courseID
	 	+ ", Number of Sections: " + numOfSections + ", Max Number of Students: " + maxStudentAmount
		+ ", Min Number of Students: " + minStudentAmount;
    }
}
