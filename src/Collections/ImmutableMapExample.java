package Collections;

import java.util.Map;

public class ImmutableMapExample
{
    public static void main(String[] args) {
        // Create an immutable map
        Map<String, Integer> map = Map.of("a", 1, "b", 2, "c", 3);

        // Print the map
        System.out.println(map);

        // Try to add a new key-value pair
        //map.put("d", 4);

        Map<String, Integer> unmodifiableMap = Map.ofEntries(Map.entry("Akshit", 99), Map.entry("Aman", 98));

        System.out.println(unmodifiableMap);

        //unmodifiableMap.put("Amit", 97);
        //System.out.println(unmodifiableMap);
    }
}
