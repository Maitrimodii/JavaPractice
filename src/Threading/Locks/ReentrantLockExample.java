/*
 * ReentrantLock was introduced to overcome the limitations of synchronized block.
 *
 * Major Problems In Synchronized:
 * 1. Cannot perform time-based locking (like lock for 5 seconds only).
 * 2. Cannot check if the lock is already acquired.
 * 3. Cannot interrupt a thread while waiting for lock.
 * 4. Cannot perform "fair" or "unfair" locking.
 *
 * ReentrantLock solves all these problems by providing:
 * - tryLock()
 * - tryLock(time, TimeUnit)
 * - interruptible lock acquisition
 * - fair locking
 */

package Threading.Locks;

import java.util.concurrent.locks.ReentrantLock;

class MyThread extends Thread
{
    Display display;
    String name;
    MyThread(Display display, String name)
    {
        this.display = display;
        this.name = name;
    }
    public void run()
    {
        display.wish(name);
    }
}

class Display
{
    ReentrantLock l = new ReentrantLock();

    public void wish(String name)
    {
        l.lock();
        for(int i=0;i<10;i++)
        {
            System.out.print("Good Morning: ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name);
        }
        l.unlock();
    }

}
public class ReentrantLockExample
{
    public static void main(String[] args) {
        Display display = new Display();

        MyThread myThread1 = new MyThread(display, "Dhoni");

        MyThread myThread2 = new MyThread(display, "Yuvraj");

        myThread1.start();

        myThread2.start();
    }
}
