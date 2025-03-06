//uses doubly linked list to maintain order of elements

package Collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample
{
    public static void main(String[] args) {
        //if accessOrder is true, then elements which are recently used are kept on end of list
        //if accessOrder is false, then elements are kept in the order they are inserted
        LinkedHashMap<String, Integer> studentMap =  new LinkedHashMap<>(2, 0.5f, true);

        studentMap.put("a", 4);

        studentMap.put("b", 2);

        studentMap.put("c", 3);

        System.out.println("Initial LinkedHashMap: " + studentMap);
        for(Map.Entry<String, Integer> entry : studentMap.entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        studentMap.get("a");
        studentMap.get("b");

        System.out.println("After accessing c: " + studentMap);
        for(Map.Entry<String, Integer> entry : studentMap.entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
