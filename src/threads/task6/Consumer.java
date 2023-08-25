package threads.task6;

public class Consumer extends Thread {
    private String name;
    private final Store store;

    public Consumer(Store store, String name) {
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
                    store.get();
                }
            }
        }
    }
}

