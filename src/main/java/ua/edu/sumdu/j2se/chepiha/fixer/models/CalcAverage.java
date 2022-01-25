package ua.edu.sumdu.j2se.chepiha.fixer.models;

public class CalcAverage {
    private int count;
    private int sum;

    public CalcAverage() {
        count = 0;
        sum = 0;
    }

    public void addMark(int mark){
        sum = sum + mark;
        count++;
    }

    public double getAverageMark(){
        if(count == 0){
            return 0;
        }
        return (double) Math.round(10* sum/count)/10;
    }

    public void setDefault(){
        count = 0;
        sum = 0;
    }
}
