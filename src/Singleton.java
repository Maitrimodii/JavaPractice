class SingletonClass{
    private static SingletonClass instance;

    private SingletonClass()
    {
        System.out.println("singleton is instantiated");
    }

    public static SingletonClass getInstance(){
            if(instance == null)
            {
                instance = new SingletonClass();
            }

            return instance;
    }

    public static void doSomething()
    {
        System.out.println("something is done");
    }
}

public class Singleton {
    public static void main(String[] args) {
        SingletonClass.getInstance();
        SingletonClass.doSomething();
    }
}
