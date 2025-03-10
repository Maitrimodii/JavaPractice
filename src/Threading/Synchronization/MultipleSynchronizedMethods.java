// If calling multiple synchronized methods of the same object then the thread will acquire the lock of the object.
// Other threads cannot access the synchronized methods of that object.

package Threading.Synchronization;

class MyThread1 extends Thread
{
    Displays display;

    MyThread1(Displays display)
    {
        this.display = display;
    }
    public void run()
    {
        display.wish();
    }
}

class MyThread2 extends Thread
{
    Displays display;

    MyThread2(Displays display)
    {
        this.display = display;

    }
    public void run()
    {
        display.wish1();
    }
}

class Displays
{
    public synchronized void wish()
    {
        for(int i=0;i<10;i++)
        {
            System.out.print("Good Morning: " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void wish1()
    {
        for(int i=0;i<10;i++)
        {
            System.out.print("Good Morning: " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


public class MultipleSynchronizedMethods
{
    public static void main(String[] args) {
        Displays d = new Displays();
        MyThread1 t1 = new MyThread1(d);
        MyThread2 t2 = new MyThread2(d);

        t1.start();
        t2.start();
    }
}
