// If multiple threads are waiting for the CPU and we want to give chance to all threads then we can use yield method.
// If multiple threads of same priority are waiting for the CPU then which thread will get the chance we cannot expect.
// Thread will move from running state to runnable state.

package Threading.ThreadMethods;

public class YieldExample
{
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for(int i=0;i<10;i++)
            {
                System.out.println("Child Thread");
                Thread.yield();// this will pause the current thread and give chance to waiting threads of same priority
            }
        };

        Thread thread = new Thread(runnable);

        thread.start();

        for(int i=0;i<10;i++)
        {
            System.out.println("Main Thread");
        }
    }
}
