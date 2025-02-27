//there can be only one public class in java file and it should match the file name
//main method is static jvm has to create an object which leads to extra memory allocation
public class first {
    static int num1 = 2;
    int age = 20; //instance variable;
    public static void main(String[] args) {
        // local variable cannot be static
        int num = 10;//defining local number
        System.out.println(num);
    }
}

