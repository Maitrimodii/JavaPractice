class OverloadingExample{
    //given in hierarchy
    void display(double d){
        System.out.println("double");
    }
    void display(float f){
        System.out.println("float");
    }

    void display(long d){
        System.out.println("long");
    }
//    void display(int d){
//        System.out.println("int");
//    }
    void display(short d){
        System.out.println("short");
    }
    void display(byte d){
        System.out.println("byte");
    }
}
public class MethodOverloading {
    public static void main(String[] args) {
        OverloadingExample obj = new OverloadingExample();
        obj.display(10);//calls int because need to typecast it to byte or short to call that method
    }
}
