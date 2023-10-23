package stream.task2;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= 20; i += 2) {
            list.add(i);
        }
        list.stream().forEach(System.out::println);
        System.out.println(list.stream().map(i -> i * 2.54).collect(Collectors.toList()));
        System.out.println(list.stream().map(i -> i * 2.54).reduce((i1, i2) -> i1 + i2).stream().
                collect(Collectors.toList()));
    }
}
