package Interface;

//Interface cannot contain concrete methods
// Interface Declared
//constructor and main methods are not allowed

interface testInterface {

    // public, static and final
    final int a = 20;

    // public and abstract
    //used to provide default implementation
    //concrete method
    default void display(){
        System.out.println("print") ;
    }

    void display1();

    static void fun(){
        System.out.println("hello");
    }
}

// Class implementing interface
class TestClass implements testInterface {

    // Implementing the capabilities of
    //overrides the
//      public void display(){
//        System.out.println("Interface");
//    }

    //implements abstract method
    public void display1(){
        System.out.println("print");
        testInterface.fun();
    }

}

public class InterfaceExample {
    public static void main(String[] args)
    {
        TestClass t = new TestClass();
        t.display();//calls the interface default method
        t.display1();
        System.out.println(t.a);
    }
}
