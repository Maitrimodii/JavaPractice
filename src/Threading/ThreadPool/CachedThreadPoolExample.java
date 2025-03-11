// cachedThreadPool() creates a thread pool that creates new threads as needed,
// but will reuse previously constructed threads when they are available.
// CachedThreadPool creates unlimited threads temporarily and kills them after 60 seconds if idle.
// use case: when you have a lot of short-lived asynchronous tasks and load is not predictable.

package Threading.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 1; i <= 10; i++) {
            int task = i;
            executor.execute(() -> {
                System.out.println("cached thread pool " + Thread.currentThread().getName() +
                        " processing task: " + task);
                processRequest();
            });
        }

        executor.shutdown();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        ExecutorService executor1  = Executors.newFixedThreadPool(4);

        for (int i = 1; i <= 10; i++) {
            int task = i;
            executor1.execute(() -> {
                System.out.println(Thread.currentThread().getName() +
                        " processing task: " + task);
                processRequest();
            });
        }

        executor1.shutdown();
    }

    private static void processRequest() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
