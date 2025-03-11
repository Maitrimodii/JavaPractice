package Threading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample
{
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for(int i=0;i<10;i++){
            int task = i;
            executor.execute(() -> {
                System.out.println("Thread Name: " + Thread.currentThread().getName() + " executing task " + task);
                countDownLatch.countDown();
            });
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("All tasks completed");

        executor.shutdown();


    }
}
