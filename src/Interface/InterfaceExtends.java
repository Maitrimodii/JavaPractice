package Interface;

interface A{
    default void display(){
        System.out.println("hello");
    }
}
interface B{
    default void display(){
        System.out.println("print");
    }
}
interface C extends A,B {
    default void display(){
        //super.display();//shows error which display method to call
        A.super.display();//need to explicitly call
    }
}

public class InterfaceExtends implements C{
    public static void main(String[] args) {
            InterfaceExtends obj = new InterfaceExtends();
            obj.display();//calls A display
    }
}
