package org.example;

import java.util.List;

public class Field {
    private String name;
    private List<Course> courseList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public Field(String name, List<Course> courseList) {
        this.name = name;
        this.courseList = courseList;
    }
}
