package threads.callable.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CallableNumberGenerator implements Callable {
    private Random random = new Random();
    private List<Integer> list = new ArrayList<>();
    @Override
    public List<Integer> call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(1, 100));
        }
        Thread.sleep(1000);
        return list;
    }
}

class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            CallableNumberGenerator callable = new CallableNumberGenerator();
            Future<List<Integer>> future = pool.submit(callable);
            System.out.println(future.get());
        }
        pool.shutdown();
    }
}

