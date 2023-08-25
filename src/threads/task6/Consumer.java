package threads.task6;

public class Consumer extends Thread {
    private String name;
    Store store;

    public Consumer(Store store, String name) {
        super(name);
        this.store = store;
    }

    @Override
    public void run() {
        synchronized (store) {
            while (Store.totalCountOfProcessedItems <= 10_00000)
                store.get();
        }
    }
}

