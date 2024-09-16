package ProjectAsli.person;
import ProjectAsli.Classroom;
import ProjectAsli.Study;


public class Student extends Person implements Study {
    private long studentId;
    private String enttanceYear;
    private String field;
    private Classroom classroom;

    public long getstudentId() {
        return studentId;
    }

    public void studentId(long studentId) {
        this.studentId = studentId;
    }

    public String getEnttanceYear() {
        return enttanceYear;
    }

    public void setEnttanceYear(String enttanceYear) {
        this.enttanceYear = enttanceYear;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
  public  void read() {
      System.out.println("styding");
  }

  public void participateInClass(Classroom classroom) {
      this.classroom=classroom;
      System.out.println(classroom.getName());
  }
  public Student(String firstName, String lastName, Gender gender, String nationality, long studentId, String enttanceYear, String field){
        super(firstName,lastName,nationality,gender);
        this.studentId=studentId;
        this.enttanceYear=enttanceYear;
        this.field=field;


  }

}
