package ua.edu.sumdu.j2se.chepiha.fixer.models.Group;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

    @XmlAttribute(name="firstname")
    private String firstname;
    @XmlAttribute(name="lastname")
    private String lastname;
    @XmlAttribute(name="groupnumber")
    private String groupnumber;
    @XmlElement(name="subject")
    private List<Subject> subjects;
    @XmlElement(name="average")
    private double average;

    public Student(){}

    public Student( String firstname, String lastname, String groupnumber, double average, List<Subject> subjects) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.groupnumber = groupnumber;
        this.average = average;
        this.subjects = subjects;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGroupnumber() {
        return groupnumber;
    }

    public void setGroupnumber(String groupnumber) {
        this.groupnumber = groupnumber;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        StringBuilder subjectsString = new StringBuilder();
        if(subjects != null){
            for(Subject subject: subjects){
                subjectsString.append(subject.toString());
            }
        }

        return "Student{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", groupnumber='" + groupnumber + '\'' +
                ", average=" + average +
                ", subjects=" + subjectsString.toString() +
                '}';
    }
}
