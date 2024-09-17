package org.example;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String nationality;
    private String entranceYear;


    public Person(String name, String lastName, int age, String nationality, String entranceYear) {
        this.firstName = name;
        this.lastName = lastName;
        this.age = age;
        this.nationality = nationality;
        this.entranceYear = entranceYear;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEntranceYear() {
        return entranceYear;
    }

    public void setEntranceYear(String entranceYear) {
        this.entranceYear = entranceYear;
    }

}
