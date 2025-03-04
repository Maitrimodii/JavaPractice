package Collections;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListVsArrayList {
    public static void main(String[] args) {
        System.out.println("Running with CopyOnWriteArrayList:");
        runWithCopyOnWriteArrayList();

        System.out.println("\nRunning with Regular ArrayList (No Sync):");
        runWithRegularArrayList();// This will cause issues concurrentModificationException
    }

    // CopyOnWriteArrayList (Thread-safe)
    private static void runWithCopyOnWriteArrayList() {
        var list = new CopyOnWriteArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Thread writerThread = new Thread(() -> {
            try
            {
                for (var item : list)
                {
                    list.add(6);
                    Thread.sleep(500);
                }
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        });

        Thread readerThread = new Thread(() -> {
            try
            {
                for (var item : list)
                {
                    System.out.println("Reader (CopyOnWriteArrayList): " + item);
                    Thread.sleep(500);
                }
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        });

        writerThread.start();
        readerThread.start();

        try
        {
            writerThread.join();
            readerThread.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    private static void runWithRegularArrayList()
    {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Thread writerThread = new Thread(() -> {
            try
            {
                for (var item : list)
                {
                    list.add(6); // Concurrent modification
                    Thread.sleep(500);
                }
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        });

        Thread readerThread = new Thread(() -> {
            try
            {
                for (var item : list)
                {
                    System.out.println("Reader (Regular List): " + item);
                    Thread.sleep(500);
                }
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        });

        writerThread.start();
        readerThread.start();

        try
        {
            writerThread.join();
            readerThread.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
