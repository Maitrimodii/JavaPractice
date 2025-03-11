// If sleep method is called before wait method then this will lead to deadlock.
// To prevent this we can add timeout to the wait method.

package Threading.InterThreadCommunication;

public class InterThreadCommunicationExample
{
    public static void main(String[] args)
    {
        InterThreadCommunicationExample obj = new InterThreadCommunicationExample();
        Runnable runnable = () -> {
          synchronized (obj){
                for(int i=0;i<5;i++)
                {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                obj.notify();
          }
        };
        Thread thread1 = new Thread(runnable);

        thread1.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (obj){
            System.out.println("Main thread calling wait method");
            try {
                obj.wait(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Main thread got notification");
        }
    }
}
