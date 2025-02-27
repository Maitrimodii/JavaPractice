package Static;

//static block and variable are executed in order they are present
public class StaticBlock{

    // Static variable - belongs to the class rather than any instance
    static int num;

    // Static block - executed once when the class is loaded into memory before main method
    static {
        // Initialize the static variable 'num' inside the static block
        num = 20;

        //static int x= 10;  //Error: Static local variables are not allowed

        System.out.println("Static block executed. Static variable 'num' initialized.");
    }

    // Static method - can be called without creating an instance of the class
    // It can access and manipulate static variables
    public static void displayNum() {
        System.out.println("Static method: num = " + num);
    }

    // Main method - entry point of the program, used for standalone execution
    public static void main(String[] args) {
        System.out.println("Main method: num = " + num);

        displayNum();
    }
}
