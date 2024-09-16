//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        Person person = new Person();
//        person.setName("John");
//        person.setAge(23);
//
//        Person person2 = new Person();
//        person2.setName("Jane");
//        person2.setAge(22);
//
//        System.out.println(person2.getAge()+person2.getName());
//        System.out.println(person.getAge()+person.getName());


//        Person Reyhane =new Person("Ali",30);
//        Person Ali=new Person("man",40);
//        Reyhane.display();
//        Reyhane.increment();

//        Rectangle Rectangle=new Rectangle(10,20);
//        Rectangle.area();
//        Rectangle.perimeter();

        Employee employee=new Employee("Reyhane","IT",20);
        Employee employee2=new Employee("Ali","IT",10);

         employee.printEmployeeDetails();
         employee.compareSalaries(employee2);


    }
}