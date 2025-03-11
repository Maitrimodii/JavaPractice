// It is impossible to change the daemon nature of the thread once it is started.
// If you try to change the daemon nature of the thread after starting it, it will throw IllegalThreadStateException.
// If there are only daemon threads running in the JVM then JVM will shutdown the JVM and end the program.
// It is impossible to change the daemon nature of the main thread.
// Daemon threads have low priority.
// It follows the parent-child relationship.
// If the parent thread is daemon then the child thread will also be daemon.

package Threading.ThreadMethods;

public class DaemonThreads
{
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Child Thread");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.setDaemon(true);
        t.start();
        System.out.println("is child thread daemon " + t.isDaemon());
        System.out.println(" is  main thread daemon " + Thread.currentThread().isDaemon());
        System.out.println("End of main thread");
    }
}
