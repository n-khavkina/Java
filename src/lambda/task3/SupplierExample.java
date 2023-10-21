package lambda.task3;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Random random = new Random();
        Supplier<Integer> supplier = () -> random.nextInt(1,11);
        System.out.println(test(supplier));

    }
    public static int test(Supplier<Integer> supplier){
        return supplier.get();
    }
}
