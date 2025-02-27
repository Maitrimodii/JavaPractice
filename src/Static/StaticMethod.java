package Static;

//static method can be overloaded but cannot be overridden
//cannot use this and super in static method
//directly cannot access non static variable but can create instance and using that it can access non static variable and methods

public class StaticMethod {

    public static void main(String[] args) {
//        Sample.method1();
//        Complex.method2();
//*****Method hiding****
        Sample obj = new Complex();//this will call sample method not complex due to method hiding
        Complex obj1 = new Complex();
        obj.method2();
        obj1.method2();
    }
}
class Sample{
    static int a = 10;

    int b = 20;

    static{
        //method1();
        //method2();
        //static block can have non-static variable and method
    }
    // can access only static method and variable
    static void method1(){
        a = 20;
        // b = 10; compilation error cannot make static reference to non-static field
        Sample obj = new Sample();
        obj.b = 30;// using object we can access instance variable and methods
        //method2();
        //System.out.println(this.b); cannot use this and super
    }
    static void method2(){
        //a = 30;
        System.out.println("hellos");
    }

//     void method2(){
//        //a = 30;
//        System.out.println("hellos");
//    } if this method is static in child class than it will show error that cannot override method2()


}
class Complex extends Sample{
    //this is called method hiding
    static void method2(){
        System.out.println("hello");
    }
}