package threads.task6;

public class Consumer extends Thread {
    private String name;
    Store store;

    public Consumer(Store store, String name) {
        super(name);
        this.store = store;
    }

    @Override
    public synchronized void run() {
        while (Store.totalCountOfProcessedItems <= 10_000)
            store.get();
    }
}

