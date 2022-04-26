package executor;

import java.util.concurrent.Executor;

/**
 * @author: Fchen
 * @date: 2022/4/22 10:11 上午
 * @desc: TODO
 */
public class MyExecutor implements Executor {
    private String name;

    public MyExecutor(String name) {
        this.name = name;
    }

    @Override
    public void execute(Runnable command) {
       new Thread(command).run();
    }
}
