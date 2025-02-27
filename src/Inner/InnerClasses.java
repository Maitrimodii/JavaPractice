package Inner;
//non static inner class cannot declare static members except for constant (final)
//can access both static and non static members
//static inner class can declare static members and can access outer class static members also but
// cannot access the non static members directly need instance
//local inner class can be only abstract or final

class Outer{
    //local inner class can access to only final members
    int y = 30;
    public void show(){
        int x = 20;//internally acts as a final because it is not modified but if modified then give error
        //x = 30;

        System.out.println(x);

        class Inner{
            int a = 20;
            public void show1(){
                System.out.println(x);// if try to access non final variables in inner class it will give compile time error
            }
        }
        Inner in = new Inner();
        in.show1();
    }
}
public class InnerClasses {
    public static void main(String[] args) {
        Outer obj = new Outer();
        obj.show();
    }
}
