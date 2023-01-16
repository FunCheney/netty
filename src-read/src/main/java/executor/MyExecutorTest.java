package executor;

/**
 * @author Fchen
 * @date 2022/4/22 10:12 上午
 * @desc TODO
 */
public class MyExecutorTest {

    public static void main(String[] args) {
        MyExecutor executor = new MyExecutor("test");
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread());
            }
        });
        System.out.println(Thread.currentThread());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread());
            }
        });

    }
}
