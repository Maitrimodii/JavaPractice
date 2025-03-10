package Threading.Synchronization;

class A {
    // Scenario 1: Class-level lock
    public static synchronized void classLock() {
        System.out.println(Thread.currentThread().getName() + " acquired Class Lock");
        try { Thread.sleep(1000); } catch (InterruptedException e) { }
    }

    // Scenario 2: Object-level lock
    public synchronized void objectLock() {
        System.out.println(Thread.currentThread().getName() + " acquired Object Lock");
        try { Thread.sleep(1000); } catch (InterruptedException e) { }
    }

    // Scenario 3: Nested Lock (Reentrant Lock)
    public synchronized void nestedLock() {
        System.out.println(Thread.currentThread().getName() + " acquired Outer Lock");
        innerLock();
    }

    public synchronized void innerLock() {
        System.out.println(Thread.currentThread().getName() + " acquired Inner Lock");
    }

    // Scenario 4: Acquiring two object locks
    public void twoObjectLock(A a2) {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " acquired Lock on Object 1");
            synchronized (a2) {
                System.out.println(Thread.currentThread().getName() + " acquired Lock on Object 2");
            }
        }
    }

    // Scenario 5: Deadlock
    public void deadlock(A a2) {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " acquired Lock on Object 1");
            try { Thread.sleep(1000); } catch (InterruptedException e) { }

            System.out.println(Thread.currentThread().getName() + " trying to acquire Lock on Object 2");
            synchronized (a2) {
                System.out.println(Thread.currentThread().getName() + " acquired Lock on Object 2");
            }
        }
    }
}

public class MultipleLockByThread {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();

        // Case 1: Class-level Lock
        new Thread(() -> A.classLock(), "Thread-1").start();

        // Case 2: Object-level Lock
        new Thread(() -> a1.objectLock(), "Thread-2").start();

        // Case 3: Nested Lock (Reentrant Lock)
        new Thread(() -> a1.nestedLock(), "Thread-3").start();

        // Case 4: Two Object Locks
        new Thread(() -> a1.twoObjectLock(a2), "Thread-4").start();

        // Case 5: Deadlock
//        new Thread(() -> a1.deadlock(a2), "Thread-5").start();
//        new Thread(() -> a2.deadlock(a1), "Thread-6").start();
    }
}

