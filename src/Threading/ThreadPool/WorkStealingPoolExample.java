//use case: when you have a lot of short-lived asynchronous tasks and load is not predictable.

package Threading.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkStealingPoolExample {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newWorkStealingPool();

        for (int i = 0; i < 10; i++) {

            int task = i;

            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " executing task " + task);
            });
        }

        executor.shutdown();

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
