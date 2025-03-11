//If forget to unlock the lock then it leads to deadlock.
//To prevent this we can use try-finally block to unlock the lock.
//If we are not using try-finally block then we can use tryLock method of ReentrantLock class.
//Try with resources is not possible with ReentrantLock.

package Threading.Locks;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample2
{
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            static ReentrantLock l = new ReentrantLock();

            @Override
            public void run() {
                if(l.tryLock()){
                    System.out.println(Thread.currentThread().getName()+" acquired lock");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        l.unlock();
                        //l.unlock();// cannot unlock twice throws IllegalMonitorStateException
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " did not get the lock, performing alternative operation.");
                }
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();

    }
}
