package Collections;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample
{
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        map.put("d", 10);
        map.put("b", 2);
        map.put("c", 30);

        System.out.println(map.get("a"));

        System.out.println(map.containsKey("b"));

        System.out.println(map.containsValue(10));

        map.replace("b", 2, 20);

        System.out.println(map);

        map.compute("c", (k, v) -> v + 100);

        System.out.println(map);

        map.merge("b", 10, Integer::sum);

        System.out.println(map);

        map.putIfAbsent("a", 1);

        System.out.println(map);
    }
}
