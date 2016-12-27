package application.elements;

import java.util.Objects;

public class Teacher {

  private String name;
  private int ID;
  private int numOfCourses;
  private boolean isChair;
  private Course[] sections;
  private Lunch lunch;
  private Subject subject;
  
  public Teacher(Subject subject, String name, int ID, boolean isChair){
    this.name = name;
    this.subject = subject;
    this.isChair = isChair;
    this.sections = new Course[8];
    this.ID = ID;
    setNumOfCourses();
  }
  
  /*Sets number of courses they teach based on subject and position*/
  private void setNumOfCourses(){
    if(subject == Subject.SCIENCE || subject == Subject.ENGLISH)
      this.numOfCourses = 4;
    else
      this.numOfCourses = 5;
    
    if(isChair)
      this.numOfCourses--;
  }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public int getNumOfCourses() {
        return numOfCourses;
    }

    public boolean isIsChair() {
        return isChair;
    }

    public Course[] getSections() {
        return sections;
    }

    public Lunch getLunch() {
        return lunch;
    }

    public Subject getSubject() {
        return subject;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.name);
        hash = 61 * hash + this.ID;
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
        final Teacher other = (Teacher) obj;
        if(this.ID != other.ID)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Teacher{" + "name=" + name + ", ID=" + ID + ", numOfCourses=" + numOfCourses + ", isChair=" + isChair + ", sections=" + sections + ", lunch=" + lunch + ", subject=" + subject + '}';
    }
}