// If both parent thread and child thread wait for each other then there will be a deadlock

package Threading.ThreadMethods;

public class JoinMethodExample
{
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();

        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
//            try
//            {
//                mainThread.join();// this will lead to deadlock because both main thread and child thread are waiting for each other
//                //Thread.currentThread().join();// this will leads to deadlock because it is trying to make the current thread to wait for itself
//            }
//            catch (InterruptedException e)
//            {
//                throw new RuntimeException(e);
//            }

            for(int i=0;i<10;i++)
            {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Child Thread");
            }
        };

        Thread thread = new Thread(runnable);

        thread.start();

        thread.join();// main thread will wait until child thread completes

        // thread.join(1000);// main thread will wait until child thread completes or 1000 milliseconds

        for(int i=0;i<10;i++)
        {
            System.out.println("Main Thread");
        }
    }
}
