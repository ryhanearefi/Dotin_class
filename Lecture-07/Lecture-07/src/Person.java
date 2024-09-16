public class Person {
    private String name;
    private int age;
    private static  int count=0;

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        count++;

    }
    public void increment() {
        System.out.println("Increment Person"+count);
    }

  public void display() {
        System.out.println("Name: " + name+ " Age: " + age);

  }

}
