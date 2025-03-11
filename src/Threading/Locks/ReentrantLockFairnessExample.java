/*
 * ReentrantLock supports two types of locking:
 *
 * Fair Lock:
 * - Threads acquire locks in the order they requested.
 * - No thread is starved.
 * - Always first-come, first-serve basis (like a Queue).
 *
 * Unfair Lock (Default):
 * - JVM will randomly give the lock to any thread.
 * - Some threads may starve (never get the lock).
 * - Unfair locks are faster (preferred in high-performance systems).
 */


package Threading.Locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockFairnessExample
{
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            static ReentrantLock l = new ReentrantLock(true);

            @Override
            public void run() {
                do {
                    try {
                        if (l.tryLock(5000, TimeUnit.MILLISECONDS)) {
                            System.out.println(Thread.currentThread().getName() + " acquired lock");
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
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } while (true);

            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();
    }
}
