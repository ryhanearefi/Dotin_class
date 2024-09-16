public class Employee {
    private String name;
    private String jobtitle;
    private double salary;
    private  static double tax=0.1;

    public Employee(String name, String jobtitle, double salary) {
        this.name = name;
        this.jobtitle = jobtitle;
        this.salary = salary;
    }

    public double AnualSalary() {
        return salary*12;

    }

    public  void  SalaryKhales() {
        System.out.println(AnualSalary()-AnualSalary()*tax);
    }

    public void printEmployeeDetails() {
        System.out.println("Name: " + name);
        System.out.println("Job Title: " + jobtitle);
        System.out.println("SalaryNakhales: " + salary);


    }

    public void compareSalaries(Employee thatEmployee) {
         if(this.salary>thatEmployee.salary) {
           System.out.println(this.name+"has more income");
    } else if (thatEmployee.salary>this.salary) {
             System.out.println(thatEmployee.name+" has more salary");
         }
         else {
            System.out.println("income are equal");
        }

         }

    }
