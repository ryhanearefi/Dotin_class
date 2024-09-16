package ProjectAsli.person;

public class DepartmentManager extends Employee{
    public void calculateSalary() {
        System.out.println("calculate salary");

    }
    public void claculateFee() {
        System.out.println
                ("claculate fee");

    }
    public DepartmentManager(String firstName, String lastName, String nationalCode, Gender gender, ContractType contractType, int salary) {
        super(firstName, lastName, nationalCode, gender, contractType, salary);
    }
}
