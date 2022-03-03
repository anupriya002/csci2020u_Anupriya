package com.example.lab05;

import javafx.collections.ObservableList;

public class StudentRecord {
    public String studentID = "";
    public float midtermGrade = 0.0f;
    public float assignmentGrade = 0.0f;
    public float finalExamGrade = 0.0f;
    public float finalMark = 0.0f;
    public String letterGrade = "";

    public StudentRecord(String studentID, float midtermGrade, float assignmentGrade, float finalExamGrade){
        this.studentID = studentID;
        this.midtermGrade = midtermGrade;
        this.assignmentGrade = assignmentGrade;
        this.finalExamGrade = finalExamGrade;
    }

    //calculate final mark
    public float calcFinalMark(){

        //20% assignment
        float assignmentWeighted = (float) (this.assignmentGrade * 0.2);

        //30% midterm
        float midtermWeighted = (float) (this.midtermGrade * 0.3);

        //50% final
        float finalWeighted = (float) (this.finalExamGrade * 0.5);

        //get final mark
        finalMark = (assignmentWeighted + midtermWeighted + finalWeighted) * 100;
        return finalMark;

    }

    //calculate final letter grade based on final mark
    public String calcLetterGrade(){

        //grade F: if 0 <= finalMark <= 49
        if (this.finalMark >= 0 && this.finalMark <= 49){
            this.letterGrade = "F";
        }

        //grade D: if 50 <= finalMark <= 59
        else if (this.finalMark >= 50 && this.finalMark <= 59){
            this.letterGrade = "F";
        }

        //grade C: if 60 <= finalMark <= 69
        else if (this.finalMark >= 60 && this.finalMark <= 69){
            this.letterGrade = "F";
        }


        //grade B: if 70 <= finalMark <= 79
        else if (this.finalMark >= 70 && this.finalMark <= 79){
            this.letterGrade = "F";
        }

        //grade A: if 80 <= finalMark <= 100
        else if (this.finalMark >= 80 && this.finalMark <= 100){
            this.letterGrade = "F";
        }

        return letterGrade;

    }


}
