package reflection.task1;

import java.util.Arrays;

public class Man {
    private String name;
    private String surname;
    private int age;

    public Man(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public void run(int speed) {
        System.out.println("Я бегу со скоростью " + speed);
    }

    public void sleep() {
        for (int i = 0; i < 3; i++) {
            System.out.println("zzz");
        }
        System.out.println("Я проснулся!");
    }

    public void greet() {
        System.out.println("Привет!");
    }

    public void printClassInformation() {
        System.out.println("Class " + Man.class.getSimpleName() + "\n" +
                "Fields:\n" + Arrays.toString(Man.class.getDeclaredFields()) + "\n" +
                "Constructors:\n" + Arrays.toString(Man.class.getConstructors()) + "\n" +
                "Methods:\n" + Arrays.toString(Man.class.getDeclaredMethods()));
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
