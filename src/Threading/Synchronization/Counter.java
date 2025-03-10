package Threading.Synchronization;

public class Counter
{
    int count = 0;

    Thread mainThread = Thread.currentThread();
    public synchronized void increment()
    {
        count++;
//        try {
//            System.out.println(Thread.currentThread().getName());
//            mainThread.join();
//            Thread.currentThread().join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread thread1 = new Thread(() -> {
            for(int i=0;i<1000;i++)
            {
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for(int i=0;i<1000;i++)
            {
                counter.increment();
            }
        });

        thread1.start();

        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(counter.count);
    }

}
