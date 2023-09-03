package threads.callable.task3;

import java.io.*;
import java.time.LocalTime;
import java.util.concurrent.*;

public class Stopwatch implements Callable {
    private File file;
    private LocalTime localTime = LocalTime.now();

    @Override
    public synchronized String call() throws Exception {
        file = new File("src/threads/callable/task3/test.txt");
        file.createNewFile();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write("Hello World " + localTime + "\n");
            System.out.println(Thread.currentThread().getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String result = reader.readLine();
            StringBuilder stringBuilder = new StringBuilder("");
            while (result != null) {
                stringBuilder.append(result).append("\n");
                result = reader.readLine();
            }
            return stringBuilder.toString();
        }
    }
}

class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            Stopwatch stopwatch = new Stopwatch();
            Future<String> future = pool.submit(stopwatch);
            System.out.println(future.get());
        }
        pool.shutdown();
    }
}


