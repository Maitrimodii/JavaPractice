package Collections;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExample
{
    public static void main(String[] args) {
        //Streams are used to process collections of objects
        //A stream is a sequence of objects that supports various methods which can be pipelined to produce the desired result
        //process collection of data in declarative and functional way
        //embrace functional programming
        //improve readability and maintainability
        //Efficiently process large amounts of data
        //Parallel processing

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println(numbers.stream().filter(x -> x % 2 == 0).count());

        Stream<Integer> stream = numbers.stream();
        //from arrays
        String[] array = {"Akshit", "Amit", "Ankit", "Ankur"};

        Stream<String> stream1 = Arrays.stream(array);

        //using stream.of
        Stream<String> a = Stream.of("Akshit", "Amit", "Ankit", "Ankur");

        //generate the infinite stream
        Stream<Integer> generate = Stream.generate(() -> 1);

        List<Integer> lists = Stream.iterate(1, x -> x * 2).collect(Collectors.toList());

        System.out.println(lists);

        //Intermediate operations
        //They are always lazy will be executed only when a terminal operation is invoked
        Stream<String> stringStream = Arrays.stream(array).filter(x -> x.startsWith("A"));

        System.out.println(stringStream.collect(Collectors.toList()));

        List<String> mapStream = Arrays.stream(array).map(String::toUpperCase).collect(Collectors.toList());

        System.out.println(mapStream);

        List<String> sortedStream = mapStream.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());

        System.out.println(sortedStream);

        System.out.println(Stream.iterate(1, x -> x * 2).limit(10));

        //using terminal operations to get the result
        //collect
        System.out.println(numbers.stream().skip(1).collect(Collectors.toList()));

        //for each
        numbers.stream().forEach(System.out::println);

        //reduce :combine all elements of the stream into a single result
        Optional<Integer> op = numbers.stream().reduce((x, y) -> x + y);
        System.out.println(op.get());

        //count
        System.out.println(numbers.stream().count());

        //anymatch, allmatch, nonematch
        System.out.println(numbers.stream().anyMatch(x -> x % 2 == 0));
        System.out.println(numbers.stream().allMatch(x -> x % 2 == 0));
        System.out.println(numbers.stream().noneMatch(x -> x % 2 == 0));

        //findfirst, findany
        System.out.println(numbers.stream().findFirst().get());
        System.out.println(numbers.stream().findAny().get());

        //summation of numbers
        System.out.println(numbers.stream().reduce(Integer::sum).get());
        System.out.println(numbers.stream().reduce(0, Integer::sum));

        //peek
        //performs an action on each element as it is consumed
        numbers.stream().peek(System.out::println).count();

        Stream<Integer> streams = numbers.stream();
        stream.forEach(System.out::println);
        //stream.map(String::toUpperCase);//throws an error stream cannot be called again after termination operation

        //Collecting to list
        List<String> names = Arrays.asList("Akshit", "Amit", "Ankit", "Ankur");
        List<String> result = names.stream().filter(x -> x.startsWith("A")).collect(Collectors.toList());

        System.out.println(result);

        //Collecting to set
        List<String> result1 = names.stream().filter(x -> x.startsWith("A")).collect(Collectors.toList());
        System.out.println(result1);

        //Collecting to specific collection
        ArrayDeque<String> collect = names.stream().filter(x -> x.startsWith("A")).collect(Collectors.toCollection(ArrayDeque::new));
        System.out.println(collect);

        //joining Strings
        String result2 = names.stream().collect(Collectors.joining(","));
        System.out.println(result2);

        //grouping by
        Map<Integer, List<String>> result3 = names.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(result3);

    }
}
