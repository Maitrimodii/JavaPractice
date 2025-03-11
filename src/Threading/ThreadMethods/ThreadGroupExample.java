package Threading.ThreadMethods;

public class ThreadGroupExample
{
    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("Parent Group");

        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + " is running");
        };


        Thread t1 = new Thread(group, runnable, "Thread 1");

        Thread t2 = new Thread(group, runnable, "Thread 2");

        System.out.println("Main Thread Group Name: " + Thread.currentThread().getThreadGroup());

        t1.start();

        t2.start();

        System.out.println("active threads in group " + group.activeCount());

        System.out.println("Thread Group Name: " + t1.getThreadGroup());

    }
}
