package threads.callable.task3;

import threads.callable.task2.CallableNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Stopwatch implements Callable {

    @Override
    public List<Integer> call() throws Exception {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
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


