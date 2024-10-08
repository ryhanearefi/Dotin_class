package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class AcademicField {
    private String name;
    private List<Student> students;
    private List<Course> courseList;

    public AcademicField(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.courseList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
