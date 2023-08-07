package Exception.Task3;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("Введите имя:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        try {
            validateName(name);
        } catch (InvalidNameException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void validateName(String name) throws InvalidNameException {
        if (!name.matches("[A-ZА-Я][a-zа-я]+")) {
            throw new InvalidNameException("Введено неверное имя!");
        }
    }
}

