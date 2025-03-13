package Threading;

class SharedResource {

    private volatile boolean running = true;
    //private boolean running = true; // Without volatile, may cause infinite loop

    public void stop() {
        running = false;
        System.out.println("Stop method called.");
    }

    public void run() {
        System.out.println("Thread started.");
        while (running) {

        }
        System.out.println("Thread stopped.");
    }
}

public class VolatileExample {
    public static void main(String[] args) throws InterruptedException {
        SharedResource resource = new SharedResource();

        Thread thread = new Thread(resource::run);
        thread.start();

        Thread.sleep(1000);
        resource.stop(); // Request to stop the thread

        thread.join();
        System.out.println("Main thread exits.");
    }
}
