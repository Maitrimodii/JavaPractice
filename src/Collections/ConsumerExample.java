package Collections;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerExample
{
    public static void main(String[] args) {
        Consumer<Integer> add = (n) -> System.out.println(n + 2);

        add.accept(4);

        Consumer<String> addString = (s) -> System.out.println(s + " World");

        addString.accept("Hello");

        Consumer<Integer> multiply = (n) -> System.out.println(n * 2);

        multiply.accept(4);

        Consumer<Integer> addAndMultiply = add.andThen(multiply);//add.andThen(multiply) is equivalent to multiply(add(n))

        addAndMultiply.accept(4);

        BiConsumer<Integer, Integer> isEvenSum = (x,y) -> System.out.println((x + y) % 2 == 0);

        System.out.println(isEvenSum);

    }
}
