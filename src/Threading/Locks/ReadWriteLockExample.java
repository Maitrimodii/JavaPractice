
package Threading.Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample
{
    int count = 0;

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private final Lock writeLock = lock.writeLock();

    private final Lock readLock = lock.readLock();

    public void increment()
    {
        writeLock.lock();

        try{
            count++;
        } finally {
            writeLock.unlock();
        }
    }
    public int getCount()
    {
        readLock.lock();

        try{
            return count;
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockExample counter = new ReadWriteLockExample();

        Runnable writeRunnable = () -> {
            for(int i=0;i<10;i++)
            {
                counter.increment();
                System.out.println(Thread.currentThread().getName() + " incremented");
            }
        };

        Runnable readRunnable = () -> {
            for(int i=0;i<10;i++)
            {
                System.out.println(Thread.currentThread().getName() + " read count as " + counter.getCount());
            }
        };

        Thread writerThread = new Thread(writeRunnable);

        Thread readerThread1 = new Thread(readRunnable);

        Thread readerThread2 = new Thread(readRunnable);

        writerThread.start();

        readerThread1.start();

        readerThread2.start();


        try
        {
            writerThread.join();

            readerThread1.join();

            readerThread2.join();

        }
        catch (InterruptedException e)
        {
            System.out.println("Main thread interrupted");
        }

        System.out.println("Main thread read count as " + counter.getCount());

    }
}
