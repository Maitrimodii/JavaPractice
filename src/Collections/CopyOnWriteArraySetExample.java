package Collections;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetExample {
    public static void main(String[] args) {
        Set<String> set = new CopyOnWriteArraySet<>();

        // Adding elements
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        set.add("Apple"); // Duplicate won't be added

        System.out.println("Initial Set: " + set);

        // Iterating and modifying the set simultaneously
        for (String fruit : set) {
            if (fruit.equals("Banana")) {
                set.add("Dragonfruit"); //
            }
        }

        System.out.println("Modified Set: " + set);
    }
}

