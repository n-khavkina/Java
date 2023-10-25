package stream.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Test {
    private static final Random random = new Random();

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        list.stream().map(integer -> random.nextInt(1, 10)).
                filter(integer -> integer % 2 == 0).
                map(String::valueOf).
                collect(Collectors.toSet()).
                forEach(System.out::println);
    }
}
