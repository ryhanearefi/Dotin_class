package ProjectAsli;

import ProjectAsli.person.*;

public class Main {
    public static void main(String[] args) {

        Student student1 = new Student("sahar","vahedi","12354545", Gender.Female,123,"1400","Math");
        Student student2 = new Student("fateme","yosefi","142554545", Gender.Female,1234,"1400","History");
        Student student3 = new Student("ali","vahedi","12354545", Gender.Male,123,"1400","Physics");
        Student student4 = new Student("sara","vahedi","12355545", Gender.Female,123,"1400","Art");
        Teacher teacher1=new Teacher("ghafer","ghaferi","111",Gender.Male, ContractType.Fulltime,60000000);
        Teacher teacher2=new Teacher("moj","mojtahed","111",Gender.Male, ContractType.Fulltime,60000000);
        Teacher teacher3=new Teacher("Ali","mahghani","111",Gender.Male, ContractType.Fulltime,60000000);
        Manager manager=new Manager("niaz", "naeima", "00132645", Gender.Male, ContractType.Fulltime, 1000000);

        DepartmentManager departmentManager = new DepartmentManager("soheila", "naghi", "213416", Gender.Female, ContractType.Fulltime,1000000);
        DepartmentManager departmentManager1 = new DepartmentManager("nahid", "yaghoubi", "213416", Gender.Female, ContractType.Fulltime, 1000000);
        DepartmentManager departmentManager2 = new DepartmentManager("jalal", "khoda", "213416", Gender.Male, ContractType.Fulltime, 1000000);
        DepartmentManager departmentManager3 = new DepartmentManager("mehdi", "khordadi", "213416", Gender.Male, ContractType.Fulltime, 1000000);



        Classroom classroom1=new Classroom("201B",teacher1,new Student[]{student1,student2});
        Classroom classroom2=new Classroom("405C",teacher3,new Student[]{student2,student3,student4});

        University university=new University("sharif",new Classroom[]{classroom2,classroom1},new Student[]{student1,student2,student3,student4},new Teacher[]{teacher1,teacher2,teacher3}, manager, new DepartmentManager[] {departmentManager, departmentManager1, departmentManager2, departmentManager3});




    }
}