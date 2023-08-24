package threads.task5;

public class Deadlock {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();
    private static Object lock3 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread() {
            public void run() {
                synchronized (lock1) {
                    System.out.println("Thread 1: locked object 1");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (lock2) {
                        System.out.println("Thread 1: locked object 2");
                    }
                }
            }
        };

        Thread thread2 = new Thread() {
            public void run() {
                synchronized (lock2) {
                    System.out.println("Thread 2: locked object 2");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (lock3) {
                        System.out.println("Thread 2: locked object 3");
                    }
                }
            }
        };
        Thread thread3 = new Thread() {
            public void run() {
                synchronized (lock3) {
                    System.out.println("Thread 3: locked object 3");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (lock1) {
                        System.out.println("Thread 3: locked object 1");
                    }
                }
            }
        };
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
