package threads.test1;

public class MyThread extends Thread {
    private String name;

    public MyThread(String name) {
        super(name);
    }

    private int counter;

    @Override
    public void run() {
        while (counter < 20) {
            counter++;
            Main.globalCounter++;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(Thread.currentThread().getName() + " counter: " + counter + " GC: " +
                    Main.globalCounter + "\n");
        }
    }

}
