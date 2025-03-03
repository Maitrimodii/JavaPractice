package Collections;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.function.Predicate;

public class LinkedListExample {
    public static void main(String[] args) {
        // Creating object of class linked list
        var object = new LinkedList<String>();

        // Adding elements to the linked list
        object.add("A");
        object.add("B");
        object.addLast("C");//O(1)
        object.addFirst("D");//O(1)
        object.add(2, "E");
        object.add("F");
        object.add("G");
        System.out.println("Linked list : " + object);

        // Removing elements from the linked list
        object.remove("B");//O(n)
        object.remove(3);//O(n)
        object.removeFirst();//O(1)
        object.removeLast();//O(1)
        object.removeIf(x -> x.equals("G"));//O(n)
        System.out.println("Linked list after deletion: " + object);

        // Finding elements in the linked list
        var status = object.contains("E");

        if(status)
            System.out.println("List contains the element 'E' ");
        else
            System.out.println("List doesn't contain the element 'E'");

        // Number of elements in the linked list
        var size = object.size();
        System.out.println("Size of linked list = " + size);

        // Get and set elements from linked list
        var element = object.get(2);//O(n)
        System.out.println("Element returned by get() : " + element);
        object.set(2, "Y");
        System.out.println("Linked list after change : " + object);

        var animals = new LinkedList<String>(Arrays.asList("dog", "cat", "fox"));
        System.out.println(animals);

        var animalsToRemove = new LinkedList<String>(Arrays.asList("cat", "fox"));
        animals.removeAll(animalsToRemove);
        System.out.println(animals);
    }
}
