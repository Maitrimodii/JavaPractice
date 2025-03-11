// Not recommended to use this approach as if one task take too long to complete than it will pile up the queue.
// submit()
package Threading.ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FixedThreadPoolExample
{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for(int i=0;i<5;i++){
            int task = i;
            executor.execute(() -> {
                System.out.println("Thread Name: " + Thread.currentThread().getName() + " executing task " + task);
            });
        }

        List<Future<?>> futureList = new ArrayList<>();

        for(int i=0;i<5;i++){
            int task = i;
            futureList.add(executor.submit(() -> {
                System.out.println("Thread Name and store result in future: " + Thread.currentThread().getName() +
                        " executing task " + task);
                return "success";
            }));
        }

        Thread.sleep(1000);

        for(Future<?> ans : futureList){
            ans.cancel(false);
            System.out.println(ans.get());
            System.out.println("Is task completed: " + ans.isDone());
            System.out.println("Is task cancelled: " + ans.isCancelled());
        }


        // This will lead to graceful shutdown of the executor
        // It will wait for all the tasks to complete before shutting down
        // It will not accept any new tasks
        // If you want to shutdown immediately, use executor.shutdownNow()

        executor.shutdown();

        System.out.println("All tasks submitted");
    }
}
