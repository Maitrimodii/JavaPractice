package Inner;

class Parent{
    int a = 20;
    public void method2(){
        System.out.println("hello of parent");
    }
    class Inner{
        int b = 20;
        public void method1(){
            System.out.println("hello of method1");
        }
    }
}
class Child extends Parent{

}
public class InheritanceWithInner {
    public static void main(String[] args) {
        Child obj = new Child();

        Parent.Inner objInner = obj.new Inner();
        System.out.println(objInner.b);
    }
}
