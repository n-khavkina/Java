package threads.task6;

import java.util.Random;

public class Producer extends Thread {
    private String name;
    private Store store;
    private Random random = new Random();

    public Producer(Store store, String name) {
        super(name);
        this.store = store;
    }

    @Override
    public synchronized void run() {
        while (Store.totalCountOfProcessedItems <= 10_000) {
            store.put(random.nextInt(1, 5));
        }
    }
}
