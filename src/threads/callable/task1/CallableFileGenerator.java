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
    public List<String> call() throws Exception {
        file = new File("src/threads/callable/task1/test" + number + ".txt");
        file.createNewFile();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write("java_" + number++);
            System.out.println(Thread.currentThread().getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread.sleep(1000);
        File[] files = new File("src/threads/callable/task1").listFiles();
        List<String> list = new ArrayList<>();
        for (File f : files) {
            list.add(f.getName());
        }
        return list;
    }
}

class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            CallableFileGenerator callable = new CallableFileGenerator();
            Future<List<String>> future = pool.submit(callable);
            System.out.println(future.get());
        }
        pool.shutdown();
    }
}
