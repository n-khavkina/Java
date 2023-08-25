package threads.task6;

import java.util.LinkedList;
import java.util.Queue;

public class Store {
    private Queue<Integer> queue = new LinkedList<>();
    private static int totalCountOfProcessedItems;
    static final int MAX_TOTAL_COUNT_OF_PROCESSED_ITEMS = 10_000;

    public void put(int element) {
        if (queue.size() >= 100) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        } else {
            queue.offer(element);
            System.out.println(Thread.currentThread().getName() + " добавил " + element + "\n" + queue);
            notify();
        }
    }

    public void get() {
        if (queue.isEmpty() || queue.size() <= 80) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
            notify();
        } else {
            totalCountOfProcessedItems++;
            System.out.println(Thread.currentThread().getName() + " забрал " + queue.poll() + " count=" + totalCountOfProcessedItems + "\n" + queue);
            notify();
        }
    }

    public static int getTotalCountOfProcessedItems() {
        return totalCountOfProcessedItems;
    }

}
