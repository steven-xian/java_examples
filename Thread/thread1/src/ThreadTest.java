
public class ThreadTest {
    public static void main(String[] args) {
        startThread("thread1");
        startThread("thread2");
        startThread("thread3");
        startThread("thread4");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void print(String msg) {
        System.out.println(msg);
    }

    private static void startThread(String name) {
        Runnable r = () -> print("thread " + name + " start");
        Thread t = new Thread(r);
        t.start();
    }
}
