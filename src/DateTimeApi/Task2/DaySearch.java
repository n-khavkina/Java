package DateTimeApi.Task2;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DaySearch {
    private static ZoneId zone = ZoneId.of("Asia/Yerevan");
    private static LocalDateTime today = LocalDateTime.now(zone);

    public static void main(String[] args) {
        System.out.println("Текущая дата в Ереване: " +
                today.format(DateTimeFormatter.ofPattern("dd MMMM uuuu HH:mm")));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество дней:");
        int dayNum = scanner.nextInt();
        LocalDateTime date = today.minusDays(dayNum);
        System.out.println(date.format(DateTimeFormatter.ofPattern("dd MMMM uuuu HH:mm")));
    }
}
