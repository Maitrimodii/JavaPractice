package Inner;

// An anonymous class can implement only one interface at a time
// Interfaces cannot have constructors
// Static initializers are not allowed in interfaces
// Use an instance initializer block for object initialization if needed

interface Animal {
    void sound();
}

public class AnonymousClass {
    int a = 20;
    public static void main(String[] args) {
        //creating an anonymous class implementing the animal interface
        Animal obj = new Animal() {
            int b = 20;
            public void sound()
            {
                System.out.println("Meow");
            }
        };
        obj.sound(); // Output: Meow
    }
}



