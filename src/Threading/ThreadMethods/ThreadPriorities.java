// Default priority of a thread is 5 (NORM_PRIORITY)
// Thread.MIN_PRIORITY = 1
// Thread.MAX_PRIORITY = 10
// Thread.NORM_PRIORITY = 5
//priority will be inherited from parent to child

package Threading.ThreadMethods;

public class ThreadPriorities
{
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getPriority());

        //Thread.currentThread().setPriority(10);//value should be between 1 to 10 else it will throw IllegalArgumentException

        //System.out.println(Thread.currentThread().getPriority());

        Runnable runnable = () -> {

            System.out.println(Thread.currentThread().getPriority());

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

        thread.setPriority(10);

        thread.start();

        for(int i=0;i<10;i++){
            Thread.sleep(500);
            System.out.println("Main Thread");
        }
    }
}
