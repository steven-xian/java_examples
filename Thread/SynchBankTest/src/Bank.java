import java.util.Arrays;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private final double[] accounts;
    private Lock bankLock = new ReentrantLock();
    private Condition sufficientFunds;
    private Object lock = new Object();

    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
//        sufficientFunds = bankLock.newCondition();
    }

    public synchronized void transfer(int from, int to, double amount) {
//        bankLock.lock();

        try {
            while (accounts[from] < amount) {
                System.out.println("not enough money");
//                sufficientFunds.await();
                wait();
            }

//            synchronized (lock) {
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total balance: %10.2f%n", getTotalBalance());
//            }
//            sufficientFunds.signalAll();
            notifyAll();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
//            bankLock.unlock();
        }
    }

    public synchronized double getTotalBalance() {
        double sum = 0;

        for (double a : accounts) {
            sum += a;
        }

        return sum;
    }

    public int size() {
        return accounts.length;
    }
}
