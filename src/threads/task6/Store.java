package threads.task6;

import java.util.LinkedList;
import java.util.Queue;

public class Store {
    private Queue<Integer> queue = new LinkedList<>();
    static int totalCountOfProcessedItems;

    public synchronized void put(int element) {
        while (queue.size() >= 100) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
        queue.offer(element);
        System.out.println(Thread.currentThread().getName() + " добавил " + element + "\n" + queue);
        notify();
    }

    public synchronized void get() {
        if (queue.isEmpty() || queue.size() <= 80) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
            notify();
        } else {
            totalCountOfProcessedItems++;
            System.out.println(Thread.currentThread().getName() + " забрал " + queue.poll() + " count=" +
                    totalCountOfProcessedItems + "\n" + queue);
            notify();
        }
    }

}
