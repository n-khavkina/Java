package threads.task1;

import java.util.Random;

public class ThreadExample extends Thread {
    Random random = new Random();

    public ThreadExample(String name) {
        super(name);
    }

    @Override
    public void run() {
        int[] array = new int[10];
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1, 20);
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] > max) {
                max = array[i + 1];
            }
        }
        System.out.println("Thread name is: " + this.getName() + ". Maximum element is: " + max);
    }

    public static void main(String[] args) {
        ThreadExample threadExample1 = new ThreadExample("Поток 1");
        ThreadExample threadExample2 = new ThreadExample("Поток 2");
        ThreadExample threadExample3 = new ThreadExample("Поток 3");
        ThreadExample threadExample4 = new ThreadExample("Поток 4");
        ThreadExample threadExample5 = new ThreadExample("Поток 5");
        ThreadExample threadExample6 = new ThreadExample("Поток 6");
        ThreadExample threadExample7 = new ThreadExample("Поток 7");
        ThreadExample threadExample8 = new ThreadExample("Поток 8");
        ThreadExample threadExample9 = new ThreadExample("Поток 9");
        ThreadExample threadExample10 = new ThreadExample("Поток 10");
        threadExample1.start();
        threadExample2.start();
        threadExample3.start();
        threadExample4.start();
        threadExample5.start();
        threadExample6.start();
        threadExample7.start();
        threadExample8.start();
        threadExample9.start();
        threadExample10.start();
    }
}
