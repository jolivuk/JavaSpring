package org.example.homeworks.Homework1;

import org.example.homeworks.Homework1.json.JsonConverter;

public class Person {
    private final String name;
    private final String surname;
    private final int age;
    private final boolean isMarried;


    public Person( String name, String surname, int age, boolean isMarried) {
        this.isMarried = isMarried;
        this.age = age;
        this.surname = surname;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", isMarried='" + isMarried + '\'' +
                '}';
    }

//    public void changeMarriageStatus(boolean isMarried){
//        this.isMarried = isMarried;
//    }

    public void sayHelloToPerson(){
        System.out.println("Hello, " + this.name + " " + this.surname + "!!!");
    }
    public void method1(){
        System.out.println("It is method 1");
    }
    public void method2(){
        System.out.println("It is method 2");
    }
    public void method3(){
        System.out.println("It is method 3");
    }
    public void method4(){
        System.out.println("It is method 4");
    }

    public boolean checkIsAdult(){
        return age >= 18;
    }


}
