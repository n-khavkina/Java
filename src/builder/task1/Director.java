package builder.task1;

import java.util.Scanner;

public class Director {
    Scanner scanner = new Scanner(System.in);
    public Builder createNewPerson(Builder builder){
        System.out.println("Создание нового персонажа");
        System.out.println("Введите имя:");
        builder.setName(scanner.next());
        System.out.println("Введите фамилию:");
        builder.setSurname(scanner.next());
        System.out.println("Введите год рождения:");
        builder.setYearOfBirth(scanner.nextInt());
        System.out.println("Введите адрес:");
        builder.setAddress(scanner.next());
        return builder;
    }
}
