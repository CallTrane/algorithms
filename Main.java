
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class Main {
    public static void main(String[] args) {
        final Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);
        while (zeroEvenOdd.getTmp() != n) {

        }
    }
}

class ZeroEvenOdd {
    private int n;
    private int tmp = 1;
    private int signal = 0;

    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();


    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void printZero(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            if (signal != 0) {
                condition1.await();
            }
            System.out.print(signal);
            signal = tmp;
            if (tmp % 2 == 0) {
                condition3.signal();
            } else {
                condition2.signal();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printEven(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            if (signal == 0 || (tmp % 2) == 0) {
                condition2.await();
            }
            System.out.print(signal);
            if (tmp != n) {
                ++tmp;
            } else {
            }
            signal = 0;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printOdd(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            if (signal == 0 || (tmp % 2) != 0) {
                condition2.await();
            }
            System.out.print(signal);
            if (tmp != n) {
                ++tmp;
            } else {
                throw new InterruptedException();
            }
            signal = 0;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public int getTmp() {
        return this.tmp;
    }
}