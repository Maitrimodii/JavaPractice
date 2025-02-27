package Interface;

//how to prevent inheritance in java
//by making parent class constructor private or making class final
interface infMultiple{
    default void display(){
        System.out.println("helloInterface");
    }
}
class ParentMultiple{
    public void display(){
        System.out.println("helloClass");
    }
}
class Childmultiple extends ParentMultiple implements infMultiple{
//    public void display(){
//        infMultiple.super.display();// to explicitly call the interface method need to override that
//    }
}
public class MultipleInterface {
    public static void main(String[] args) {
        Childmultiple obj = new Childmultiple();
        obj.display();//class has more priority compare to interface
    }
}
