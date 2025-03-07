package Collections;

import java.util.function.Function;

public class FunctionExample
{
    public static void main(String[] args) {
        Function<Integer, Integer> add = (n) -> n + 2;

        System.out.println(add.apply(4));

        Function<String, String> addString = (s) -> s + " World";

        System.out.println(addString.apply("Hello"));

        Function<Integer, Integer> multiply = (n) -> n * 2;

        System.out.println(multiply.apply(4));

        Function<Integer, Integer> addAndMultiply = add.andThen(multiply);//add.andThen(multiply) is equivalent to multiply(add(n))

        System.out.println(addAndMultiply.apply(4));

        Function<Integer, Integer> multiplyAndAdd = add.compose(multiply);//add.compose(multiply) is equivalent to add(multiply(n))

        System.out.println(multiplyAndAdd.apply(4));
    }
}
