package org.example;



import java.util.List;

public class Course {
    private String name;
    private List<Student> studentList;
    private Professor professor;
    private List<Course> prerequisite;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Course> getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(List<Course> prerequisite) {
        this.prerequisite = prerequisite;
    }

    public Course(String name, List<Student> studentList, Professor professor, List<Course> prerequisite) {
        this.name = name;
        this.studentList = studentList;
        this.professor = professor;
        this.prerequisite = prerequisite;
    }
}
