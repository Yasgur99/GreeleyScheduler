package application.elements;

public class Teacher {

  private String name;
  private int numOfCourses;
  private boolean isChair;
  private Course[] sections;
  private Lunch lunch;
  private Subject subjectType;
  
  public Teacher(String name, Subject subjectType , boolean isChair){
    this.name = name;
    this.subjectType = subjectType;
    this.isChair = isChair;
    this.sections = new Course[8];
    setNumOfCourses();
  }
  
  private void setNumOfCourses(){
    if(subjetType == Subject.SCIENCE || subjectType == Subject.ENGLISH)
      this.numOfCourses = 4;
    else
      this.numOfCourses = 5;
    
    if(isChair)
      this.numOfCourses--;
  }
}
