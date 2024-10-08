package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseName;
    private List<Course> prerequisites; // پیش‌نیازها
    private List<Course> corequisites;  // هم‌نیازها
    private List<Student> enrolledStudents;  // لیست دانشجویان ثبت‌نامی
    private Professor professor; // استادی که درس را تدریس می‌کند
    private List<StudentGrade> studentGrades; // لیست نمرات دانشجویان

    public Course(String courseName) {
        this.courseName = courseName;
        this.prerequisites = new ArrayList<>();
        this.corequisites = new ArrayList<>();
        this.enrolledStudents = new ArrayList<>();
        this.studentGrades = new ArrayList<>();
    }

    // افزودن پیش‌نیاز
    public void addPrerequisite(Course course) {
        prerequisites.add(course);
    }

    // حذف پیش‌نیاز
    public void removePrerequisite(Course course) {
        prerequisites.remove(course);
    }

    // افزودن هم‌نیاز
    public void addCorequisite(Course course) {
        corequisites.add(course);
    }

    // حذف هم‌نیاز
    public void removeCorequisite(Course course) {
        corequisites.remove(course);
    }

    // ثبت‌نام دانشجو
    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
        studentGrades.add(new StudentGrade(student, 0)); // دانشجو ثبت‌نام می‌شود با نمره ۰
    }

    // حذف دانشجو
    public void removeStudent(Student student) {
        enrolledStudents.remove(student);
        studentGrades.removeIf(grade -> grade.getStudent().equals(student));
    }

    // ثبت‌نام استاد
    public void assignProfessor(Professor professor) {
        this.professor = professor;
    }

    // حذف استاد
    public void removeProfessor() {
        this.professor = null;
    }

    // مدیریت نمرات دانشجو
    public void assignGrade(Student student, int grade) {
        for (StudentGrade sg : studentGrades) {
            if (sg.getStudent().equals(student)) {
                sg.setGrade(grade);
                break;
            }
        }
    }

    // متدهای getter و setter
    public String getCourseName() {
        return courseName;
    }

    public List<Course> getPrerequisites() {
        return prerequisites;
    }

    public List<Course> getCorequisites() {
        return corequisites;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public Professor getProfessor() {
        return professor;
    }

    public List<StudentGrade> getStudentGrades() {
        return studentGrades;
    }
}
