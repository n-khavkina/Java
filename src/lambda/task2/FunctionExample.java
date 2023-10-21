package lambda.task2;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<Integer, String> function = i -> {
            if (i > 0) {
                return "Положительное число";
            } else if (i < 0) {
                return "Отрицательное число";
            } else {
                return "Ноль";
            }
        };
        System.out.println(test(-4, function));

    }

    public static String test(Integer i, Function<Integer, String> f) {
        return f.apply(i);
    }
}