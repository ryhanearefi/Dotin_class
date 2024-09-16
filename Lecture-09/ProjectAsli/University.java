package ProjectAsli;
import ProjectAsli.person.*;

public class University {

    private String name;
    private Classroom[] classrooms;
    private Student[] students;
    private Teacher[] teachers;
    private Manager manager;
    private DepartmentManager[] departmentManagers;

    public University(String name, Classroom[] classrooms, Student[] students, Teacher[] teachers, Manager manager, DepartmentManager[] departmentManagers) {
        this.name = name;
        this.classrooms = classrooms;
        this.students = students;
        this.teachers = teachers;
        this.manager = manager;
        this.departmentManagers = departmentManagers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Classroom[] getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(Classroom[] classrooms) {
        this.classrooms = classrooms;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher[] teachers) {
        this.teachers = teachers;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public DepartmentManager[] getDepartmentManagers() {
        return departmentManagers;
    }

    public void setDepartmentManagers(DepartmentManager[] departmentManagers) {
        this.departmentManagers = departmentManagers;
    }

}
