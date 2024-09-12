package org.example.homeworks.homework1;

public class Person {
    private final String name;
    private final String surname;
    private final int age;
    private final boolean isMarried;
    private Cat cat;


    public Person( String name, String surname, int age, boolean isMarried) {
        this.isMarried = isMarried;
        this.age = age;
        this.surname = surname;
        this.name = name;
    }

    public Person(String name, String surname, int age, boolean isMarried, Cat cat) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.isMarried = isMarried;
        this.cat = cat;
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
