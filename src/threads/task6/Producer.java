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
    public void run() {
        while (true) {
            if (Store.totalCountOfProcessedItems <= 5) {
                store.put(random.nextInt(1, 5));
            } else {
                return;
            }
        }
    }
}
