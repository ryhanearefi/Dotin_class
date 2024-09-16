package ProjectAsli.person;

public class Manager extends Employee{
    public void order(){
        System.out.println("order");
    }
    public Manager(String firstName, String lastName, String nationality, Gender gender, ContractType contractType, int salary) {
        super(firstName, lastName, nationality, gender, contractType, salary);
    }

}
