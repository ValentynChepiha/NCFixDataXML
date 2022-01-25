package ua.edu.sumdu.j2se.chepiha.fixer.models.Group;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="group")
public class Group {

    private List<Student> students;

    public Group(){}

    public Group(List<Student> students) {
        this.students = students;
    }

    @XmlElement(name="student")
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {

        StringBuilder studentsString = new StringBuilder();
        if(students != null){
            for(Student student: students){
                studentsString.append(student.toString());
            }
        }

        return "Group{" +
                "students=" + studentsString.toString() +
                '}';
    }
}
