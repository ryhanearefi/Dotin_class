package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private List<Faculty> faculties;

    public University(String name) {
        this.name = name;
        this.faculties = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public Faculty getFacultyByName(String facultyName) {
        for (Faculty faculty : faculties) {
            if (faculty.getName().equalsIgnoreCase(facultyName)) {
                return faculty;
            }
        }
        return null;
    }
}
