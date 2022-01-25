package ua.edu.sumdu.j2se.chepiha.fixer.models;

import ua.edu.sumdu.j2se.chepiha.fixer.models.Group.Group;
import ua.edu.sumdu.j2se.chepiha.fixer.models.Group.Student;
import ua.edu.sumdu.j2se.chepiha.fixer.models.Group.Subject;

public class VerifyRules {

    private boolean logConsole = false;

    public VerifyRules(){
    }

    public VerifyRules(boolean logConsole){
        this.logConsole = logConsole;
    }

    public void verifyAverage(Group group){

        for (Student student: group.getStudents()) {
            CalcAverage calc = new CalcAverage();
            if(student.getSubjects() == null){
                continue;
            }

            for(Subject subject: student.getSubjects()){
                calc.addMark(subject.getMark());
            }
            double calcAvr = calc.getAverageMark();
            if(student.getAverage() != calcAvr ){
                if(logConsole){
                    System.out.println("Fixed average: "
                            + student.getFirstname() + " " + student.getLastname()
                            + ", old: " + student.getAverage()+ ", new: " + calcAvr);
                }
                student.setAverage(calcAvr);
            }
        }
    }

}
