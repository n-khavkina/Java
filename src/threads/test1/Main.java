package threads.test1;

public class Main {
    static int globalCounter;

    public static void main(String[] args) {
        MyThread myThread1 = new MyThread("Поток 1");
        MyThread myThread2 = new MyThread("Поток 2");
        MyThread myThread3 = new MyThread("Поток 3");
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
}
