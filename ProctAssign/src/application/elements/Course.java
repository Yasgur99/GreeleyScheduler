package application.elements;

import java.util.List;
import java.util.ArrayList;

public class Course{
    
    /*Subject to be used to make sure teachers are compatible and organize courses*/
    private Subject subject;
    /*The formal title as found in the admissions book*/
    private String courseName;
    /*Unique ID to be used for quick lookup of courses*/
    private int courseID;
    /*Based on the demand and max class size*/
    private int numOfSections;
    /*To be used to see if class if full*/
    private int maxStudentAmount;
    /*Might be depricated in future depending on how important this is to the district*/
    private int minStudentAmount;
    /*List of sections*/
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

    /*Sets number of sections which is determined within application.logic*/
    public void setNumOfSections(int numOfSections){
	this.numOfSections = numOfSections;
    }
    
    /*Returns max amount of students allowed in this course*/
    public int getMaxStudentAmount(){
        return this.getMaxStudentAmount();
    }
    

    /*Adds a section of this course to the list*/
    public void addSection(Section section){
        if(section.getCourse() == this)
            sections.add(section);
    }
    
    @Override
    public String toString(){
	return "Subject: " + subject + ", Course Name: " + courseName + ", Course ID: " + courseID
	 	+ ", Number of Sections: " + numOfSections + ", Max Number of Students: " + maxStudentAmount
		+ ", Min Number of Students: " + minStudentAmount;
    }
}
