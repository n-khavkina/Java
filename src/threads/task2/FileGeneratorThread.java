package threads.task2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class FileGeneratorThread implements Runnable {
    private String name;
    private File file = new File("src/threads/task2/test.txt");
    private Random random = new Random();

    public FileGeneratorThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1, 20);
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.write(Arrays.toString(array) + "\n");
            System.out.println("Thread name is: " + name);
        } catch (IOException e) {
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new FileGeneratorThread("Поток 1"));
        Thread thread2 = new Thread(new FileGeneratorThread("Поток 2"));
        Thread thread3 = new Thread(new FileGeneratorThread("Поток 3"));
        Thread thread4 = new Thread(new FileGeneratorThread("Поток 4"));
        Thread thread5 = new Thread(new FileGeneratorThread("Поток 5"));
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
