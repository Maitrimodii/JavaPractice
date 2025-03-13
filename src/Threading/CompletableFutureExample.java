package Threading;

import java.util.concurrent.*;

public class CompletableFutureExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Asynchronous Task Execution
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            sleep(1);
            return "Task 1 Completed";
        }, executor);

        // Chaining with thenApply() - Transform the result
        CompletableFuture<String> future2 = future1.thenApply(result -> {
            return result + " → Processed in thenApply()";
        });

        // Chaining with thenCompose() - Dependent async calls
        CompletableFuture<String> future3 = future2.thenCompose(result ->
                CompletableFuture.supplyAsync(() -> result + " → thenCompose() Called", executor)
        );

        // Combining two futures using thenCombine()
        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> {
            sleep(2);
            return "Task 2 Completed";
        }, executor);

        CompletableFuture<String> combinedFuture = future3.thenCombine(future4, (res1, res2) ->
                res1 + " + " + res2
        );

        // Running multiple tasks in parallel using allOf()
        CompletableFuture<String> future5 = CompletableFuture.supplyAsync(() -> {
            sleep(3);
            return "Task 3 Completed";
        }, executor);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(future1, future4, future5);

        //  Exception Handling using exceptionally() and handle()
        CompletableFuture<String> futureWithError = CompletableFuture.supplyAsync(() -> {
            sleep(1);
            if (true) throw new RuntimeException("Something went wrong!");
            return "This won't be executed";
        }).exceptionally(ex -> "Handled Error: " + ex.getMessage());

        CompletableFuture<String> futureWithHandle = CompletableFuture.supplyAsync(() -> {
            sleep(1);
            if (true) throw new RuntimeException("Another error!");
            return "Won't execute";
        }).handle((res, ex) -> (ex == null) ? res : "Recovered from: " + ex.getMessage());

        //  Run tasks in parallel without returning a result
        CompletableFuture<Void> runAsyncExample = CompletableFuture.runAsync(() -> {
            sleep(1);
            System.out.println("Background Task Completed");
        }, executor);

        // Get and print results
        allTasks.join(); // Wait for all tasks to complete
        System.out.println(future3.join());  // Chained result
        System.out.println(combinedFuture.join()); // Combined future result
        System.out.println(futureWithError.join()); // Error handling result
        System.out.println(futureWithHandle.join()); // Handle() result

        // Shutdown executor
        executor.shutdown();
    }

    // Helper method to simulate delay
    private static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
