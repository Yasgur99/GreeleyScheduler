package application.elements;


/**
 * @author yasgur99
 *
 */

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

    public Teacher(String name, Department department) {
        this.name = name;
        this.department = department;
        this.sections = new ArrayList[]{new ArrayList<Section>(), new ArrayList<Section>()};
    }

    /*Checks if teacher has a course either semsester*/
    public boolean hasClasses() {
        return sections[0].size() > 0 || sections[1].size() > 0;
    }

    /*Adds a class to the respective semester(s) of sections without prforming checks*/
    public void addClass(Section section) {
        if(section.getSemester() == Semester.BOTH_SEMESTERS){
            sections[0].add(section);
            sections[1].add(section);
        } else if(section.getSemester() == Semester.SEMESTER_1)
            sections[0].add(section);
        else
            sections[1].add(section);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Section>[] getSections() {
        return sections;
    }

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
