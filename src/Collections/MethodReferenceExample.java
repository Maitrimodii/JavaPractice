package Collections;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class MethodReferenceExample
{
    public static void main(String[] args) {
        // Method reference to a static method
        // Syntax: ContainingClass::staticMethodName
        // The following lambda expression can be replaced with a method reference
        // Runnable r = () -> System.out.println("Hello World");
        Runnable r = MethodReferenceExample::printHelloWorld;
        r.run();

        // Method reference to an instance method of an object
        // Syntax: ContainingObject::instanceMethodName
        // The following lambda expression can be replaced with a method reference
        // Consumer<String> c = (s) -> System.out.println(s);
        Consumer<String> c = System.out::println;
        c.accept("Hello World");

        // Method reference to an instance method of an existing object
        // Syntax: ContainingType::methodName
        // The following lambda expression can be replaced with a method reference
        // BiPredicate<Integer, Integer> bp = (x, y) -> x.equals(y);
        BiPredicate<Integer, Integer> bp = Integer::equals;
        System.out.println(bp.test(2, 2));

        // Method reference to a constructor
        // Syntax: ClassName::new
        // The following lambda expression can be replaced with a method reference
        // Supplier<String> s = () -> new String();
        Supplier<String> s = String::new;
        System.out.println(s.get());
    }

    private static void printHelloWorld()
    {
        System.out.println("Hello World");
    }
}
