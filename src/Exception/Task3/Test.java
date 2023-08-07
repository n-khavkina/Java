package Exception.Task3;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("Введите имя:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        try {
            validateName(name);
        } catch (InvalidName e) {
            System.out.println(e.getMessage());
        }
    }

    public static void validateName(String name) throws InvalidName {
        if (!name.matches("[A-ZА-Я][a-zа-я]+")) {
            throw new InvalidName("Введено неверное имя!");
        }
    }
}

