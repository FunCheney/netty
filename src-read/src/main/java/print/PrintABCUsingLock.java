package print;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Fchen
 * @date 2022/4/27 1:56 下午
 * @desc TODO
 */
public class PrintABCUsingLock {
    private int times;
    private int state;
    private Lock lock = new ReentrantLock();

    public PrintABCUsingLock(int times) {
        this.times = times;
    }

    private void printLetter(String name, int targetNum) {
        for (int i = 0; i < times; ) {
            lock.lock();
            try {
                if (state % 3 == targetNum) {
                    state++;
                    i++;
                    System.out.print(name);
                }
            }finally {
                lock.unlock();
            }


        }
    }

    public static void main(String[] args) {
        PrintABCUsingLock loopThread = new PrintABCUsingLock(5);

        new Thread(() -> {
            loopThread.printLetter("B", 1);
        }, "B").start();

        new Thread(() -> {
            loopThread.printLetter("A", 0);
        }, "A").start();

        new Thread(() -> {
            loopThread.printLetter("C", 2);
        }, "C").start();
    }

}
