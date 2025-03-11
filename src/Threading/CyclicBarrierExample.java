package Threading;

import java.util.concurrent.*;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, () -> System.out.println("All threads reached barrier!"));
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 9; i++) {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " reached barrier");
                try {
                    barrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " crossed the barrier");
            });
        }

        executor.shutdown();
    }
}
