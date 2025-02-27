//if method is static and instance is null then it can be accessbile using reference of class
//else it will give null pointer exception

class Test {
     final static void show() {
        System.out.println("Hello");
    }
//    void method(Object obj) {
//        System.out.println("Object");
//    }

//    void method(Integer obj) {
//        System.out.println("Integer");
//    }

//    void method(Long obj) {
//        System.out.println("Long");
//    }

//    void method(Short obj) {
//        System.out.println("Short");
//    }
//
    void method(Byte obj) {
        System.out.println("Byte");
    }

//    void method(Boolean obj) {
//        System.out.println("Boolean");
//    }

//    void method(String str) {
//        System.out.println("String");
//    }
}

public class NullObject {
    public static void main(String[] args) {
        Test obj = null;
        obj.show();  //null pointer exception is thrown
        System.out.println(obj);

        String str1 = null;
        String str2 = null;

        System.out.println(str1 == str2);
       // System.out.println(str1.equals(str2));//null pointer exception

        obj = new Test();
        obj.method(null);// if null is passed as parameter than it will call String method

        Boolean by = new Boolean(null);
        System.out.println(by);

        Object str = null;
        System.out.println(str);
    }
}
