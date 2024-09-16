package ProjectAsli;

import ProjectAsli.person.Student;
import ProjectAsli.person.Teacher;

public class Classroom {
    private String Name;
    private Teacher teacher;
    private Student[] student;

    public Classroom(String name, Teacher teacher, Student[] student) {
        Name = name;
        this.teacher = teacher;
        this.student = student;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student[] getStudent() {
        return student;
    }

    public void setStudent(Student[] student) {
        this.student = student;
    }
}
