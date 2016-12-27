package application.elements;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class Course {

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

    public Course(Subject subject, String courseName, int courseID) {
        this.subject = subject;
        this.courseName = courseName;
        this.courseID = courseID;
        this.maxStudentAmount = 25;
        this.minStudentAmount = 4;
        this.sections = new ArrayList<Section>();
    }

    /*Sets number of sections which is determined within application.logic*/
    public void setNumOfSections(int numOfSections) {
        this.numOfSections = numOfSections;
    }

    /*Adds a section of this course to the list*/
    public void addSection(Section section) {
        if(section.getCourse() == this)
            sections.add(section);
    }

    public Subject getSubject() {
        return subject;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCourseID() {
        return courseID;
    }

    public int getNumOfSections() {
        return numOfSections;
    }

    public int getMaxStudentAmount() {
        return maxStudentAmount;
    }

    public int getMinStudentAmount() {
        return minStudentAmount;
    }

    public List<Section> getSections() {
        return sections;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.courseName);
        hash = 11 * hash + this.courseID;
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
        if(this.courseID != other.courseID)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Course{" + "subject=" + subject + ", courseName=" + courseName + ", courseID=" + courseID + ", numOfSections=" + numOfSections + ", maxStudentAmount=" + maxStudentAmount + ", minStudentAmount=" + minStudentAmount + ", sections=" + sections + '}';
    }
}