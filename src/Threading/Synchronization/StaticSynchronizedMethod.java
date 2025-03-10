package Threading.Synchronization;

public class StaticSynchronizedMethod
{
    // Locks on class

    public static synchronized void printTable(int n)
    {
        for(int i=1;i<=5;i++)
        {
            System.out.println(n*i +" " +Thread.currentThread().getName());
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void printTable1(int n)
    {
            for(int i=1;i<=5;i++)
            {
                System.out.println(n*i +" " +Thread.currentThread().getName());
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

    }
    public static void main(String[] args) {
        StaticSynchronizedMethod obj = new StaticSynchronizedMethod();

        Thread thread1 = new Thread(() -> {
            for(int i=0;i<5;i++)
            {
                printTable(1);

            }
        });

        Thread thread2 = new Thread(() -> {
            for(int i=0;i<5;i++)
            {
                obj.printTable1(2);


                printTable(10);//if i did'nt get the lock on the class then it will wait and no other statement
                //will be executed below this till it gets the lock

                obj.printTable1(3);
                System.out.println("hello");

            }
        });

        thread1.start();
        thread2.start();
    }
}
