package Threading.Locks;

import java.util.concurrent.*;

class CustomTask implements Runnable {
    private Semaphore semaphore;
    private String taskName;

    public CustomTask(Semaphore semaphore, String taskName) {
        this.semaphore = semaphore;
        this.taskName = taskName;
    }

    @Override
    public void run() {
        try {
            System.out.println(taskName + " is waiting for a permit...");

            // Try acquiring a permit
            if (semaphore.tryAcquire()) {
                System.out.println(taskName + " acquired a permit!");

                // Simulate some work
                Thread.sleep(2000);

                // Release the permit after work is done
                semaphore.release();
                System.out.println(taskName + " released the permit!");
            } else {
                System.out.println(taskName + " could not acquire a permit!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class SemaphoreExample2 {
    public static void main(String[] args) throws InterruptedException {
        // Creating a semaphore with 2 permits
        Semaphore semaphore = new Semaphore(2, true); // Fairness enabled

        // Creating multiple worker threads
        Thread t1 = new Thread(new CustomTask(semaphore, "Task-1"));
        Thread t2 = new Thread(new CustomTask(semaphore, "Task-2"));
        Thread t3 = new Thread(new CustomTask(semaphore, "Task-3"));
        Thread t4 = new Thread(new CustomTask(semaphore, "Task-4"));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        Thread.sleep(1000); // Let some threads start first

        // Displaying additional semaphore information
        System.out.println("\nAvailable Permits: " + semaphore.availablePermits());
        System.out.println("Is semaphore fair? " + semaphore.isFair());
        System.out.println("Waiting Threads: " + semaphore.getQueueLength());

        // Reduce permits dynamically
        System.out.println("\n Reducing permits by 1...");
        semaphore.drainPermits();
        System.out.println("Available Permits after reduction: " + semaphore.availablePermits());

        // Ensure all threads finish execution
        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("\n All tasks completed.");
    }
}
