package application.elements;

/**
 * This class represents a Teacher. A teacher has a name, a department, and the Sections they teach
 * for each Semester. A teacher also has specific constraints that need to be satisfied. The genetic
 * algorithm will mostly focus on the constraints of the teachers as well as the times their other 
 * sections are meeting in order to create a valid schedule.
 * 
 * @author yasgur99
 * @see Semester
 * @see Section
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Teacher {

    /*Teacher name: Lastname, Firstname*/
    private String name;
    /*Department teacher belongs to*/
    private Department department;
    /*List of classes: index 0 contains SEMESTER_1 and index 1 contains SEMESTER_2*/
    private List<Section>[] sections;
    /*Boolean is true if they are the chair of their department*/
    private boolean isChair;

    /**
     * This constructor sets the instance variables to those that are given as parameters
     * and initializes any data structures that need it.
     * 
     * @param name the name of the Teacher
     * @param department the Department this Teacher belongs to
     * @param isChair if the teacher is chair of their Department
     **/
    public Teacher(String name, Department department, boolean isChair) {
        this.name = name;
        this.department = department;
        this.sections = new ArrayList[]{new ArrayList<Section>(), new ArrayList<Section>()};
        this.isChair = isChair;
    }

    /**
     * Checks if teacher has a course either Semester
     * @return whether the Teacher has any Sections either semester.
     **/
    public boolean hasClasses() {
        return sections[0].size() > 0 || sections[1].size() > 0;
    }

    /**
     * Adds a Section to the teachers List of Sections and checks which Semester the 
     * section meets.
     * 
     * @param section the section being added.
     * @see Section
     * @see Semester
     **/
    public void addSection(Section section) {
        if(section.getSemester() == Semester.BOTH_SEMESTERS){
            sections[0].add(section);
            sections[1].add(section);
        } else if(section.getSemester() == Semester.SEMESTER_1)
            sections[0].add(section);
        else
            sections[1].add(section);
    }

    /**
     * @return the name of this Teacher.
     **/
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the teacher to that of <code>name</code>.
     * @param name the name of this Teacher.
     **/
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the Department this Teacher belongs to.
     * @see Department
     **/
    public Department getDepartment() {
        return department;
    }

    /**
     * Sets the Department that this Teacher belongs to, to that of <code>department</code>.
     * @param department the Department this Teacher belongs to.
     * @see Department
     **/
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * Returns an array of List of Sections. The first List contains all the first Semester Sections
     * and the second List contains the second Semester Sections.
     * @return a List of Sections both first and second Semester that this Teacher belongs to.
     * @see Section
     * @see Semester
     **/
    public List<Section>[] getSections() {
        return sections;
    }

    /**
     * Replaces the sections that this Teacher belongs to. The first List is the first Semester Sections
     * and the Second List is the second Semester Sections.
     * @param sections a List of Sections both first and second semester that this Teacher belongs to.
     * @see Section
     * @see Semester
     **/
    public void setSections(List<Section>[] sections) {
        this.sections = sections;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.department);
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
        if(!Objects.equals(this.name, other.name))
            return false;
        if(this.department != other.department)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Teacher{" + "name=" + name + ", department=" + department + ", sections=" + sections + '}';
    }   
}