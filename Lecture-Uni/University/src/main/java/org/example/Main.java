package org.example;

import org.example.entity.University;
import org.example.entity.Student;
import org.example.entity.Professor;
import org.example.entity.Faculty;
import org.example.entity.AcademicField;
import org.example.entity.Course;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        University university = getUniversity(scanner);

        // افزودن دانشجوها از فایل
        addStudentsFromFile(university, "D:\\git_DotinClass\\Lecture-Uni\\University\\students.csv");

        // افزودن اساتید از فایل
        addProfessorsFromFile(university, "D:\\git_DotinClass\\Lecture-Uni\\University\\professors.csv");

        // نمایش دانشجویان و اساتید اضافه شده
        displayStudents(university);
        displayProfessors(university);

        // مثال‌های استفاده از متدهای جدید
        Faculty csFaculty = findOrCreateFaculty(university, "Computer Science");
        Course cs101 = new Course("CS101");

        // اضافه کردن پیش‌نیاز به درس
        Course math101 = new Course("Math101");
        addPrerequisiteOrCorequisite(cs101, math101, true);  // اضافه کردن Math101 به عنوان پیش‌نیاز برای CS101

        // ثبت‌نام دانشجو در درس
        Student ali = new Student("Ali", "Computer Science");
        enrollOrRemoveStudentFromCourse(cs101, ali, true);  // ثبت‌نام علی در CS101

        // ثبت‌نام استاد برای درس
        Professor drAhmadi = new Professor("Dr. Ahmadi", "ASSOCIATE_PROFESSOR");
        assignOrRemoveProfessorFromCourse(cs101, drAhmadi, true);  // ثبت‌نام دکتر احمدی برای تدریس CS101

        // اختصاص نمره به دانشجو
        assignGradeToStudent(cs101, ali, 95);  // اختصاص نمره 95 به علی در درس CS101

        // حذف دانشجو از درس
        enrollOrRemoveStudentFromCourse(cs101, ali, false);  // حذف علی از CS101

        // حذف استاد از درس
        assignOrRemoveProfessorFromCourse(cs101, drAhmadi, false);  // حذف دکتر احمدی از CS101
    }

    private static University getUniversity(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter University Name: ");
                String universityName = scanner.nextLine();
                if (universityName.trim().equals("")) {
                    throw new Exception("Invalid name");
                }
                return new University(universityName);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static void addStudentsFromFile(University university, String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] studentData = line.split(",");
                if (studentData.length == 2) {
                    String studentName = studentData[0].trim();
                    String major = studentData[1].trim();

                    Student student = new Student(studentName, major);
                    Faculty faculty = findOrCreateFaculty(university, major);
                    AcademicField academicField = findOrCreateField(faculty, major);
                    academicField.getStudents().add(student);
                    academicField.getCourseList().add(new Course("General Course"));

                    System.out.println("Added student: " + studentName + " in major: " + major);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + filePath);
        }
    }

    private static void addProfessorsFromFile(University university, String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] professorData = line.split(",");
                if (professorData.length == 2) {
                    String professorName = professorData[0].trim();
                    String rank = professorData[1].trim();

                    Professor professor = new Professor(professorName, rank);
                    Faculty faculty = findOrCreateFaculty(university, "General Faculty");
                    faculty.getProfessors().add(professor);

                    System.out.println("Added professor: " + professorName + " with rank: " + rank);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + filePath);
        }
    }

    private static Faculty findOrCreateFaculty(University university, String facultyName) {
        Faculty faculty = university.getFacultyByName(facultyName);
        if (faculty == null) {
            faculty = new Faculty(facultyName, new ArrayList<>());
            university.addFaculty(faculty);
            System.out.println("Created new faculty: " + facultyName);
        }
        return faculty;
    }

    private static AcademicField findOrCreateField(Faculty faculty, String fieldName) {
        for (AcademicField academicField : faculty.getAcademicFields()) {
            if (academicField.getName().equalsIgnoreCase(fieldName)) {
                return academicField;
            }
        }
        AcademicField newField = new AcademicField(fieldName);
        faculty.addField(newField);
        System.out.println("Created new field: " + fieldName);
        return newField;
    }

    // مدیریت پیش‌نیازها و هم‌نیازها
    private static void addPrerequisiteOrCorequisite(Course course, Course prerequisite, boolean isPrerequisite) {
        if (isPrerequisite) {
            course.addPrerequisite(prerequisite);
            System.out.println("Added prerequisite: " + prerequisite.getCourseName() + " to course: " + course.getCourseName());
        } else {
            course.addCorequisite(prerequisite);
            System.out.println("Added corequisite: " + prerequisite.getCourseName() + " to course: " + course.getCourseName());
        }
    }

    // ثبت‌نام یا حذف دانشجو از درس
    private static void enrollOrRemoveStudentFromCourse(Course course, Student student, boolean enroll) {
        if (enroll) {
            course.enrollStudent(student);
            System.out.println("Enrolled student: " + student.getName() + " in course: " + course.getCourseName());
        } else {
            course.removeStudent(student);
            System.out.println("Removed student: " + student.getName() + " from course: " + course.getCourseName());
        }
    }

    // ثبت‌نام یا حذف استاد از درس
    private static void assignOrRemoveProfessorFromCourse(Course course, Professor professor, boolean assign) {
        if (assign) {
            course.assignProfessor(professor);
            System.out.println("Assigned professor: " + professor.getName() + " to course: " + course.getCourseName());
        } else {
            course.removeProfessor();
            System.out.println("Removed professor from course: " + course.getCourseName());
        }
    }

    // ثبت نمره برای دانشجو در یک درس
    private static void assignGradeToStudent(Course course, Student student, int grade) {
        course.assignGrade(student, grade);
        System.out.println("Assigned grade: " + grade + " to student: " + student.getName() + " in course: " + course.getCourseName());
    }

    private static void displayStudents(University university) {
        for (Faculty faculty : university.getFaculties()) {
            System.out.println("Faculty: " + faculty.getName());
            for (AcademicField academicField : faculty.getAcademicFields()) {
                System.out.println("Field: " + academicField.getName());
                for (Student student : academicField.getStudents()) {
                    System.out.println("Student: " + student.getName());
                }
            }
        }
    }

    private static void displayProfessors(University university) {
        for (Faculty faculty : university.getFaculties()) {
            System.out.println("Faculty: " + faculty.getName());
            for (Professor professor : faculty.getProfessors()) {
                System.out.println("Professor: " + professor.getName() + ", Rank: " + professor.getLevel());
            }
        }
    }
}
