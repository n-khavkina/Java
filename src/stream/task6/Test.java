package stream.task6;

import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        System.out.println(getFirst(24));
        System.out.println(getFirst(6));
    }

    public static Integer getFirst(int n) {
        return IntStream.range(2, n)
                .filter(i -> i * 2 <= n)
                .filter(i -> i % 2 == 0)
                .filter(i -> i > 10)
                .boxed()
                .findFirst().orElse(null);
    }
}
