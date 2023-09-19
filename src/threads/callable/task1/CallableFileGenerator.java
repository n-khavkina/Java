package threads.callable.task1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;

public class CallableFileGenerator implements Callable {
    private static int number = 1;
    private File file;
    @Override
    public String call() throws Exception {
        file = new File("Java/src/threads/callable/task1/test" + number + ".txt");
        file.createNewFile();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write("java_" + number++);
            System.out.println(Thread.currentThread().getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread.sleep(1000);
        return file.getName();
    }
}

class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Set<Future<String>> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            CallableFileGenerator callable = new CallableFileGenerator();
            Future<String> future = pool.submit(callable);
            set.add(future);
        }
        for (Future<String> future : set){
            System.out.println(future.get());
        }
        pool.shutdown();
    }
}
