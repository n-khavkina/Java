package threads.task6;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();
        Producer producer1 = new Producer(store, "Производитель 1");
        Producer producer2 = new Producer(store, "Производитель 2");
        Producer producer3 = new Producer(store, "Производитель 3");
        Consumer consumer1 = new Consumer(store, "Потребитель 1");
        Consumer consumer2 = new Consumer(store, "Потребитель 2");
        producer1.start();
        producer2.start();
        producer3.start();
        consumer1.start();
        consumer2.start();


    }
}
