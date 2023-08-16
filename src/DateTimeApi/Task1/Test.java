package DateTimeApi.Task1;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Test {
    private static LocalDate currentDate = LocalDate.now();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер месяца текущего года:");
        int monthNumber = scanner.nextInt();
        LocalDate date = LocalDate.of(currentDate.getYear(), monthNumber, 1);
        while (date.isBefore(LocalDate.of(currentDate.getYear(), monthNumber + 1, 1))) {
            System.out.println(date.format(DateTimeFormatter.ofPattern("d::MMM::uuuu")));
            date = date.plusDays(1);
        }
    }
}
