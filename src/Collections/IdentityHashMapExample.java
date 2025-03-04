package Collections;

import java.util.HashMap;
import java.util.IdentityHashMap;

public class IdentityHashMapExample
{
    public static void main(String[] args) {

        IdentityHashMap<String, Integer> map = new IdentityHashMap<>();

        String key1 = new String("key");

        String key2 = new String("key");

        System.out.println(key1.hashCode());

        System.out.println(key2.hashCode());

        map.put(key1, 1);

        map.put(key2, 2);

        System.out.println(map);
    }
}
