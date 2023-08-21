package threads.task3;

import java.util.ArrayList;
import java.util.List;

public class Generator extends Thread {
    private List<Integer> list;
    private int countTo = 25;
    private static int number;

    public Generator(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            for (int i = 0; i < countTo; i++) {
                number++;
                list.add(number);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list2 = new ArrayList<>();
        Generator generator1 = new Generator(list2);
        Generator generator2 = new Generator(list2);
        Generator generator3 = new Generator(list2);
        Generator generator4 = new Generator(list2);
        generator1.start();
        generator1.join();
        generator2.start();
        generator2.join();
        generator3.start();
        generator3.join();
        generator4.start();
        generator4.join();
        for (Integer i : list2) {
            System.out.println(i);
        }
    }
}
