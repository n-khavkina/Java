package Generics.Task1;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название машины: ");
        String name1 = scanner.nextLine();
        System.out.println("Введите название мотоцикла: ");
        String name2 = scanner.nextLine();
        Car car = new Car(name1);
        Motorcycle motorcycle = new Motorcycle(name2);

        Garage<Car> garage1 = new Garage<>(car);
        Garage<Motorcycle> garage2 = new Garage<>(motorcycle);

        System.out.println(garage1);
        System.out.println(garage2);
    }
}
