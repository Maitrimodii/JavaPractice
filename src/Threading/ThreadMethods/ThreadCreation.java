package Threading.ThreadMethods;

class MyThread extends Thread
{
    //not recommended to override start method
    public void start()
    {
        super.start();//must call the super class start method or else it will not call run() method

        System.out.println("start method");
    }
    public void run()
    {
       // super.run();
        for(int i=0;i<10;i++)
        {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
            System.out.println("Child Thread");

            System.out.println(Thread.currentThread().getName());
        }
    }

    //t.start() will always call no argument run method only

    public void run(int i){
        System.out.println("Overloaded run method");
    }
}
public class ThreadCreation
{
    public static void main(String[] args) {
        MyThread t = new MyThread();// thread instantiation

        t.start();// this will create a new thread it will be in runnable state

       // t = new MyThread();

       // t.start();// IllegalThreadStateException

        //t.start is responsible for calling run method and registering thread in thread scheduler

        //t.run();// this will not create a new thread, it will run in the main thread

        try
        {
            t.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("Main Thread");
    }
}
