package threads.task6;

import java.util.Random;

public class Producer extends Thread {
    private String name;
    private final Store store;
    private Random random = new Random();

    public Producer(Store store, String name) {
        super(name);
        this.store = store;
    }

    @Override
    public void run() {
        synchronized (store) {
            while (true) {
                if (Store.getTotalCountOfProcessedItems() >= Store.MAX_TOTAL_COUNT_OF_PROCESSED_ITEMS) {
                    return;
                } else {
                    store.put(random.nextInt(1, 101));
                }
            }
        }
    }
}
