// Runnable defines the task (work to be done).
// Thread is responsible for executing that task.
// This allows creating multiple threads with different tasks without creating separate classes.
// To prevent diamond problem in java, we use interface Runnable.

package Threading.ThreadMethods;

//class MyRunnable implements Runnable{
//    public void run(){
//        for(int i=0;i<10;i++)
//        {
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("Child Thread");
//        }
//    }
//}

public class ThreadCreationUsingRunnable
{
    public static void main(String[] args) {
       // MyRunnable runnable = new MyRunnable();
    
        // This is better than the above commented code
        Runnable runnable = () -> {
            for(int i=0;i<10;i++)
            {
                //System.out.println(Thread.currentThread().getName());

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Child Thread");
            }
        };
        
        // runnable.start();// this will give compile time error

        //runnable.run();// this will not create a new thread, it will run in the main thread

        System.out.println(Thread.currentThread().getName());

        Thread.currentThread().setName("Main Thread");

        System.out.println(Thread.currentThread().getName());

        Thread thread = new Thread(runnable);

        System.out.println(thread.getName());

        thread.start();

        for(int i=0;i<10;i++)
        {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Main Thread");
        }
    }
}
