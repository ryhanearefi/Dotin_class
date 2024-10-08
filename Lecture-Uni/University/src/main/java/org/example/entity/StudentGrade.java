package org.example.entity;

public class StudentGrade {
    private Student student;
    private int grade;

    public StudentGrade(Student student, int grade) {
        this.student = student;
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
