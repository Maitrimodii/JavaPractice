//note: HashMap is not thread safe
package Collections;

import java.util.HashMap;

public class HashMapExample
{
    public static void main(String[] args) throws Exception
    {
        var map= new HashMap<Integer, String>();

        map.put(1, "one"); //O(1) and O(log n) in worst case

        map.put(24, "two");

        map.put(3, "three");

        map.put(null, null);

        map.put(null, "four");

        System.out.println(map);

        System.out.println(map.get(24));//O(1) and O(log n) in worst case

        System.out.println(map.containsKey(3));//O(1) and O(log n) in worst case

        System.out.println(map.containsValue("one")); //O(n)

        System.out.println(map.size());

        System.out.println(map.isEmpty());

        System.out.println(map.remove(24));//O(1) and O(log n) in worst case

        System.out.println(map);

        String value = map.getOrDefault(4,"default");

        System.out.println(value);

        System.out.println(map);

        var map1 = new HashMap<Integer, String>(1_500_000_000); // though 10 is passed, the capacity will be 16 because
        //it converts it to nearest value which is power of 2

        //map1.put(1, "one");
//        for (int i = 1; i <= 20; i++) {
//            map1.put(i * 16, "Value" + i); // Forces some collisions
//        }

        var tableField = HashMap.class.getDeclaredField("table");
        tableField.setAccessible(true);
        Object[] table = (Object[]) tableField.get(map1);

        System.out.println("Total elements in HashMap: " + map1.size());
        //System.out.println("Number of buckets (capacity): " + table.length);
    }
}
