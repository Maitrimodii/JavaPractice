package Collections;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

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

        //Function.identity() returns a function that always returns its input argument
        Function<Integer, Integer> identity = Function.identity();

        Integer res2 = identity.apply(5);

        System.out.println(res2);

        BiFunction<Integer, Integer, Integer> addTwoNumbers = (x,y) -> x + y;

        System.out.println(addTwoNumbers.apply(10,20));

        //UnaryOperator is a special case of a function where the input and output are of the same type

        UnaryOperator<Integer> addOne = (n) -> n + 1;

        System.out.println(addOne.apply(4));

        //BinaryOperator is a special case of a BiFunction where the input and output are of the same type
        BinaryOperator<Integer> addTwoNumbers2 = (x,y) -> x + y;

        System.out.println(addTwoNumbers2.apply(10,20));

    }
}
