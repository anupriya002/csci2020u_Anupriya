package com.example.lab08;

import javafx.collections.ObservableList;

public class StudentRecord {
    public String studentID = "";
    public Float midtermGrade = 0.0f;
    public Float assignmentGrade = 0.0f;
    public Float finalExamGrade = 0.0f;
    public Float finalMark = 0.0f;
    public String letterGrade = "";

    public StudentRecord(String studentID, float midtermGrade, float assignmentGrade, float finalExamGrade){
        this.studentID = studentID;
        this.midtermGrade = midtermGrade;
        this.assignmentGrade = assignmentGrade;
        this.finalExamGrade = finalExamGrade;
    }

    public String getStudentID(){
        return this.studentID;
    }

    public Float getAssignmentGrade(){
        return this.assignmentGrade;
    }

    public Float getMidtermGrade(){
        return this.midtermGrade;
    }

    public Float getFinalExamGrade(){
        return this.finalExamGrade;
    }

    //calculate final mark
    public Float getFinalMark(){

        //20% assignment
        float assignmentWeighted = (float) (this.assignmentGrade * 0.2);

        //30% midterm
        float midtermWeighted = (float) (this.midtermGrade * 0.3);

        //50% final
        float finalWeighted = (float) (this.finalExamGrade * 0.5);

        //get final mark
        this.finalMark = (assignmentWeighted + midtermWeighted + finalWeighted);
        return this.finalMark;

    }

    //calculate final letter grade based on final mark
    public String getLetterGrade(){

        //grade F: if 0 <= finalMark <= 49
        if (this.finalMark >= 0 && this.finalMark <= 49){
            this.letterGrade = "F";
        }

        //grade D: if 50 <= finalMark <= 59
        else if (this.finalMark >49 && this.finalMark <= 59){
            this.letterGrade = "D";
        }

        //grade C: if 60 <= finalMark <= 69
        else if (this.finalMark >59 && this.finalMark <= 69){
            this.letterGrade = "C";
        }


        //grade B: if 70 <= finalMark <= 79
        else if (this.finalMark >69 && this.finalMark <= 79){
            this.letterGrade = "B";
        }

        //grade A: if 80 <= finalMark <= 100
        else if (this.finalMark >79 && this.finalMark <= 100){
            this.letterGrade = "A";
        }

        return letterGrade;

    }


}