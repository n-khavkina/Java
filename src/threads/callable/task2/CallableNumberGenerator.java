package threads.callable.task2;

import java.util.*;
import java.util.concurrent.*;

public class CallableNumberGenerator implements Callable {
    private Random random = new Random();
    private List<Integer> list = new ArrayList<>();
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(1, 100));
        }
        int result = 0;
        for (Integer i : list){
            result+=i;
        }

        return String.valueOf(result) ;
    }
}

class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Set <Future<String>> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            CallableNumberGenerator callable = new CallableNumberGenerator();
            Future<String> future = pool.submit(callable);
            set.add(future);
        }
        for (Future<String> future : set){
            System.out.println(future.get());
        }
        pool.shutdown();
    }
}

