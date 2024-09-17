package org.example;


import java.util.List;
import java.util.Map;

public class Student extends Person {

    private String studentId;
    private Field field;
    private Faculty faculty;
    private List<Course> courseList;
    private Map<Course, Grade> gradeMap;


    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public Map<Course, Grade> getGradeMap() {
        return gradeMap;
    }

    public void setGradeMap(Map<Course, Grade> gradeMap) {
        this.gradeMap = gradeMap;
    }

    public Student(String name, String lastName, int age, String nationality, String entranceYear, String studentId, Field field, Faculty faculty, List<Course> courseList, Map<Course, Grade> gradeMap) {
        super(name, lastName, age, nationality, entranceYear);
        this.studentId = studentId;
        this.field = field;
        this.faculty = faculty;
        this.courseList = courseList;
        this.gradeMap = gradeMap;
    }
}
