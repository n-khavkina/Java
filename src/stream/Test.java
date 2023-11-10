package stream;

import java.util.function.BiFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        Stream.of("a1", "a2", "a3").filter("a1"::equals).count();
    }
}
