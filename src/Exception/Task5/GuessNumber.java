package Exception.Task5;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int count = 1;
        int x = random.nextInt(1, 101);
        System.out.println("Загадано число от 1 до 100. Угадайте число, у вас 5 попыток.");
        while (count <= 5) {
            System.out.println("Попытка номер: " + count);
            System.out.println("Введите число:");
            String input = scanner.next();
            try {
                validateNumber(input);
            } catch (InvalidNumberException e) {
                System.out.println(e.getMessage());
                count++;
                continue;
            }
            try {
                checkRange(Integer.parseInt(input));
            } catch (OutOfRangeException e) {
                System.out.println(e.getMessage());
                count++;
                continue;
            }

            if (Integer.parseInt(input) == x) {
                System.out.println("Вы угадали число!");
                break;
            } else {
                if (count == 5) {
                    System.out.println("Вы не угадали");
                } else if (Integer.parseInt(input) > x) {
                    System.out.println("Искомое число меньше");
                } else {
                    System.out.println("Искомое число больше");
                }
                count++;
            }
        }
    }

    public static void validateNumber(String number) throws InvalidNumberException {
        if (number.matches("[^\\d]")) {
            throw new InvalidNumberException("Ошибка! Надо ввести число!");
        }
    }

    public static void checkRange(int number) throws OutOfRangeException {
        if (number < 1 || number > 100) {
            throw new OutOfRangeException("Ошибка! Число должно быть в диапозоне от 1 до 100!");
        }
    }
}
