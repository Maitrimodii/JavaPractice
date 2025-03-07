package Collections;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateExample
{
    public static void main(String[] args) {
        Predicate<Integer> isEven = (n) -> n % 2 == 0;

        System.out.println(isEven.test(4));

        Predicate<String> isWordsStartsWithA = (s) -> s.startsWith("A");

        System.out.println(isWordsStartsWithA.test("Akshit"));

        Predicate<String> isWordEndsWithA = (s) -> s.endsWith("A");

        System.out.println(isWordEndsWithA.test("Akshit"));

        Predicate<String> combiningPredicates = isWordsStartsWithA.and(isWordEndsWithA);

        System.out.println(combiningPredicates.test("Akshit"));

        BiPredicate<Integer, Integer> isEvenSum = (x,y) -> (x + y) % 2 == 0;

        System.out.println(isEvenSum.test(2, 3));

    }
}
