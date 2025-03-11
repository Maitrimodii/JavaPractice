package Threading.Synchronization;

class C{
    public synchronized void d1(B b){
        System.out.println("Thread 1 starts execution of d1 method");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread 1 trying to call B's last method");
        b.last();
    }
    public synchronized void last(){
        System.out.println("Inside A's last method");
    }
}

class B{
    public synchronized void d2(C a){
        System.out.println("Thread 2 starts execution of d2 method");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread 2 trying to call A's last method");
        a.last();
    }
    public synchronized void last(){
        System.out.println("Inside B's last method");
    }
}

class MyThread3 extends Thread{
    C a = new C();
    B b = new B();

    public void m1(){
        this.start();
        a.d1(b);// this line executed by main thread
    }

    public void run(){
        b.d2(a);// this line executed by child thread
    }
}

public class Deadlock
{
    public static void main(String[] args) {
        MyThread3 t = new MyThread3();
        t.m1();
    }
}
