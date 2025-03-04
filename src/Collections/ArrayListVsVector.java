package Collections;

import java.util.ArrayList;
import java.util.Vector;

public class ArrayListVsVector {
    public static void main(String[] args) throws InterruptedException
    {

        var list = new ArrayList<>();

        var t1 = new Thread(() -> {
            for (var i = 0; i < 1000; i++)
            {
                list.add(i);
            }
        });

        var t2 = new Thread(() -> {
            for (var i = 0; i < 1000; i++)
            {
                list.add(i);
            }
        });

        t1.start();
        t2.start();

        // Wait for both threads to complete execution
        t1.join();
        t2.join();

        // Due to non-thread safety, the final size may be less than expected (2000)
        System.out.println("ArrayList size: " + list.size());

        var vector = new Vector<>();

        var t3 = new Thread(() -> {
            for (var i = 0; i < 1000; i++)
            {
                vector.add(i);
            }
        });

        var t4 = new Thread(() -> {
            for (var i = 0; i < 1000; i++)
            {
                vector.add(i);
            }
        });

        t3.start();
        t4.start();

        // Wait for both threads to complete execution
        t3.join();
        t4.join();

        // Vector is thread-safe, so the expected size will be exactly 2000
        System.out.println("Vector size: " + vector.size());
    }
}
