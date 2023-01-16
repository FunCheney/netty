package print;

/**
 * @author Fchen
 * @date 2022/4/27 11:43 上午
 * @desc TODO
 */
public class ThreadPrint99 {
    private static volatile int totalNum = 0;

    public static void main(String[] args) {
        Object lock = new Object();
        for(int i = 1; i <= 99; i++){
            int num = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        synchronized (lock){
                            while (totalNum != num){
                                lock.wait();
                            }

                            System.out.println(Thread.currentThread().getName()+":"+ num);
                            totalNum = totalNum + 1;

                            lock.notifyAll();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "thread-" + num).start();
        }
        // 主线程启动，其中totalNum是volatile修饰，线程可见性
        synchronized (lock) {
            totalNum = totalNum + 1;
            lock.notifyAll();
        }
    }
}
