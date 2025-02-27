package Constructor;
// The `this()` and `super()` calls must be the first statement in a constructor.

class Temp {
    // Default constructor
    // Calls the parameterized constructor with one argument
    Temp() {
        this(5); // Calls constructor with one parameter
        System.out.println("Default constructor");
    }

    // Parameterized constructor with one argument
    // Calls the parameterized constructor with two arguments
    Temp(int x) {
        this(x, 15); // Calls constructor with two parameters
        System.out.println("Single parameter constructor: " + x);
    }

    // Parameterized constructor with two arguments
    // The `super()` call is implicit and is executed first
    Temp(int x, int y) {
        System.out.println("Two parameter constructor: " + (x * y));
    }
}

public class ConstructorChaining {
    public static void main(String[] args) {
        // Starts the constructor chaining by invoking the default constructor
        new Temp();
    }
}
