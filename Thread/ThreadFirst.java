

//public class ThreadFirst implements Runnable {
public class ThreadFirst extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("Restart anyway");
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Exception:" + ex.getMessage());
                return;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        new Thread(new ThreadFirst()).start();
        Thread thread = new ThreadFirst();
        thread.start();

        Thread.sleep(5000);
        thread.interrupt();
    }
}