package Threading.ThreadPool;

import java.util.concurrent.atomic.AtomicInteger;

class Counter {
    private int normalCount = 0;  // No visibility or atomicity guarantee
    private volatile int volatileCount = 0; // Ensures visibility, but not atomicity
    private AtomicInteger atomicCount = new AtomicInteger(0); // Ensures both visibility and atomicity

    // Increment methods
    public void incrementNormal() {
        normalCount++;  // Not thread-safe
    }

    public void incrementVolatile() {
        volatileCount++; // Not atomic (multiple threads can interfere)
    }

    public void incrementAtomic() {
        atomicCount.incrementAndGet(); // Thread-safe atomic operation
    }

 
    public int getNormalCount() { return normalCount; }
    public int getVolatileCount() { return volatileCount; }
    public int getAtomicCount() { return atomicCount.get(); }
}

public class VolatileVsAtomicExample {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread[] threads = new Thread[100];

        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.incrementNormal();
                    counter.incrementVolatile();
                    counter.incrementAtomic();
                }
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        // Print results
        System.out.println("Normal Count (Expected 100000): " + counter.getNormalCount());
        System.out.println("Volatile Count (Expected 100000, but may be incorrect): " + counter.getVolatileCount());
        System.out.println("Atomic Count (Expected 100000): " + counter.getAtomicCount());
    }
}
