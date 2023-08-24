package threads.task4;

import static java.lang.Thread.*;
import static java.util.concurrent.TimeUnit.*;

public class MyThread implements Runnable {
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public synchronized void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + " " + i);
            try {
                SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyThread("Поток 1"));
        thread1.start();
        thread1.join();
        Thread thread2 = new Thread(new MyThread("Поток 2"));
        thread2.start();
        thread2.join();
        Thread thread3 = new Thread(new MyThread("Поток 3"));
        thread3.start();
        thread3.join();
        Thread thread4 = new Thread(new MyThread("Поток 4"));
        thread4.start();
        thread4.join();
        Thread thread5 = new Thread(new MyThread("Поток 5"));
        thread5.start();
        thread5.join();
        Thread thread6 = new Thread(new MyThread("Поток 6"));
        thread6.start();
        thread6.join();
        Thread thread7 = new Thread(new MyThread("Поток 7"));
        thread7.start();
        thread7.join();
        Thread thread8 = new Thread(new MyThread("Поток 8"));
        thread8.start();
        thread8.join();
        Thread thread9 = new Thread(new MyThread("Поток 9"));
        thread9.start();
        thread9.join();
        Thread thread10 = new Thread(new MyThread("Поток 10"));
        thread10.start();
        thread10.join();

    }

}
