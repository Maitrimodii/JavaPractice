package Collections;
import java.util.concurrent.*;

class ConcurrentHashMapCASDemo {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

        Runnable task = () -> {
            for (int i = 1; i <= 10; i++) {
                map.put(i,"Thread-1");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable task2 = () -> {
            for (int i = 11; i <= 20; i++) {
                map.put(i,"Thread-2");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        // Creating multiple threads to insert into ConcurrentHashMap
        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task2, "Thread-2");

        t1.start();
        t2.start();


        t1.join();
        t2.join();

        System.out.println(map);
    }
}
