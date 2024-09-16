package ProjectAsli.person;

public abstract class Employee extends Person {
    private int salary;
    private ContractType contractType;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }
    public Employee(String firstName, String lastName, String nationalCode, Gender gender, ContractType contractType, int salary) {
        super(firstName, lastName, nationalCode, gender);
        this.contractType = contractType;
        this.salary = salary;
    }
}
