package threads.task6;

import java.util.LinkedList;
import java.util.Queue;

public class Store {
    private Queue<Integer> queue = new LinkedList<>();
    static int totalCountOfProcessedItems;

    public synchronized void put(int element) {
        while (queue.size() >= 3) {
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
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
        totalCountOfProcessedItems++;
        System.out.println(Thread.currentThread().getName() + " забрал " + queue.poll() + " count=" +
                totalCountOfProcessedItems + "\n" + queue);
        notify();
    }

}
