// If method is synchronized then only one thread is allowed to execute the method at a time.
// If method is not synchronized then multiple threads are allowed to execute the method at a time.
// If method is synchronized then the object level lock is acquired.
// If method is static synchronized then the class level lock is acquired.
// If method is synchronized then the lock is acquired on the current object.
// If object has acquired lock on particular synchronized method then it can access all the synchronized methods of that
// object.
// If object has acquired a lock then no other thread can access the synchronized methods of that object.
// If object has acquired a lock then other threads can access the non-synchronized methods of that object.
// If object has acquired a class lock then other threads cannot access the static synchronized methods of that class.
// If object has acquired a class lock then other threads can access the static methods, non static synchronized methods
// and instant method of that class.

package Threading.Synchronization;

class MyThread extends Thread
{
    Display display;
    String name;
    MyThread(Display display, String name)
    {
        this.display = display;
        this.name = name;
    }
    public void run()
    {
        display.wish(name);
    }
}

class Display
{
    public synchronized void wish(String name)
    {
        for(int i=0;i<10;i++)
        {
            System.out.print("Good Morning: ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name);
        }
    }

}
public class SynchronizationExample
{
    public static void main(String[] args) {
        Display display1 = new Display();

        Display display2 = new Display();

        // Here, we are passing the different display object to both the threads
        // So, the output will be mixed

        MyThread myThread1 = new MyThread(display1, "Dhoni");

        MyThread myThread2 = new MyThread(display2, "Yuvraj");

        myThread1.start();

        myThread2.start();
    }
}
