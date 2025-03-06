//legacy class
//it is slow and not fail fast and fail safe
//it is synchronized
//cannot use lambda expressions
//cannot use method references
//cannot have null values and null keys
//default capacity 11
//increases by (2*old capacity)+1
//unlike hashmap load factor is not configurable
//default load factor is 0.75
//will not be converted to power of 2
//if number of elements in bucket is more than 8, then it will not be converted to tree

package Collections;

import java.util.Hashtable;

public class HashTableExample
{
    public static void main(String[] args) {
        Hashtable<String, Integer> table = new Hashtable<>();

        table.put("a", 1);//O(1)
        table.put("b",2);//O(1)
        table.put("c",3);//O(1)

        System.out.println(table);
        //table.put(null, 4);//gives null pointer exception
        //table.put(4, null);//gives null pointer exception

        System.out.println(table.get("a"));//O(1)
        System.out.println(table.containsKey("b"));//O(1)
        System.out.println(table.containsValue(3));//O(n)
        System.out.println(table.size());//O(1)
        System.out.println(table.isEmpty());//O(1)
        System.out.println(table.remove("a"));//O(1)
        System.out.println(table);
    }
}
