package Collections;

import java.util.List;
import java.util.stream.Stream;

public class ParallelStreamsExample
{
    public static void main(String[] args) {
        // Parallel Streams
        // Parallel streams are capable of processing elements concurrently on multiple threads
        // The parallel() method is used to create a parallel stream
        //workload is distributed among multiple threads

        //used for cpu intensive tasks or large data sets where tasks are independent
        //parallel streams are not suitable for tasks that are dependent on each other

        long startTime = System.currentTimeMillis();
        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(20000).toList();
        List<Integer> factorialList = list.stream().map(ParallelStreamsExample::factorial).toList();
        long endTime = System.currentTimeMillis();

        System.out.println("Time taken to calculate factorial of 20000 numbers using sequential stream: " + (endTime - startTime) + "ms");

        long start = System.currentTimeMillis();
        List<Integer> list1 = Stream.iterate(1, x -> x + 1).limit(20000).toList();
        List<Integer> factorialList1 = list.parallelStream().map(ParallelStreamsExample::factorial).toList();
        long end = System.currentTimeMillis();

        System.out.println("Time taken to calculate factorial of 20000 numbers using parallel stream: " + (end - start) + "ms");

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int[] sum = {0};
        //does not guarantee the order of the elementsf
        List<Integer> cummilativeSum = numbers.parallelStream().map(x -> sum[0] += x).toList();
        System.out.println(cummilativeSum);

    }


    private static int factorial(int n) {
        return n == 1 ? 1 : n * factorial(n - 1);
    }
}
