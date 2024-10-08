package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private String name;
    private List<AcademicField> academicFields;
    private List<Professor> professors;

    // سازنده با یک پارامتر
    public Faculty(String name) {
        this.name = name;
        this.academicFields = new ArrayList<>();
        this.professors = new ArrayList<>();
    }

    // سازنده با دو پارامتر
    public Faculty(String name, List<AcademicField> academicFields) {
        this.name = name;
        this.academicFields = academicFields != null ? academicFields : new ArrayList<>();
        this.professors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AcademicField> getAcademicFields() {
        return academicFields;
    }

    public void setAcademicFields(List<AcademicField> academicFields) {
        this.academicFields = academicFields;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public void addField(AcademicField field) {
        academicFields.add(field);
    }

    public void addProfessor(Professor professor) {
        professors.add(professor);
    }
}
