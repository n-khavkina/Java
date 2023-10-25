package stream.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {
    private static Random random = new Random();
    private static int minValue = random.nextInt(-10, 0);
    private static int maxValue = random.nextInt(1, 10);

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = minValue; i <= maxValue; i++) {
            list.add(i);
        }
        System.out.println(list.stream().anyMatch(i -> i % 5 == 0 && i % 3 == 0));
    }
}
