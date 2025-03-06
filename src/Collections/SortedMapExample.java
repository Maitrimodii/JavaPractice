//Tree map internally uses red black tree
//Tree map is sorted by keys
//Tree map is not synchronized
//Tree map is fail fast
//Tree map does not allow null keys
//Tree map allows null values
//Tree map is not thread safe

package Collections;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class SortedMapExample
{
    public static void main(String[] args)
    {
        SortedMap<String, Integer> map = new TreeMap<>();

        map.put("d",4);

        map.put("b",2);//O(log n)

        map.put("c",3);

        System.out.println(map);

        System.out.println(map.firstKey());//O(1)

        System.out.println(map.lastKey());//O(1)

        System.out.println(map.headMap("c"));//O(log n)

        System.out.println(map.tailMap("c"));//O(log n)

        System.out.println(map.containsKey("b"));//O(log n)

        System.out.println(map.containsValue(3));//O(n)

        System.out.println(map.get("b"));//O(log n)

        map.remove("c");//O(log n)

        System.out.println(map);
    }
}
