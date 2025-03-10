package Threading.ThreadMethods;

public class SleepMethodExample
{
    public static void main(String[] args)
    {
        Runnable runnable = ()  -> {
            for(int i=0;i<10;i++)
            {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e)
                {
                    System.out.println("thread interrupted");
                }
                System.out.println("Child Thread");
            }
        };

        Thread thread = new Thread(runnable);

        thread.start();

        thread.interrupt();

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
