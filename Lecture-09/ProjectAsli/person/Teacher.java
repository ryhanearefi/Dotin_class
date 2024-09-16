package ProjectAsli.person;

public class Teacher extends Employee{
   public void teaching(){
       System.out.println("teaching");
   }
    public Teacher(String firstName, String lastName, String nationalCode, Gender gender, ContractType contractType, int salary) {
        super(firstName, lastName, nationalCode, gender, contractType, salary);
    }

}
