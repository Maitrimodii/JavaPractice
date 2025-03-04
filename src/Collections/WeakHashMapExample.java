package Collections;

import java.util.WeakHashMap;

public class WeakHashMapExample
{
    public static void main(String args[])
    {
        WeakHashMap<String, Integer> studentMap = new WeakHashMap<>();

        String key = new String("a");

        String key2 = new String("b");

        studentMap.put(key, 1);

        studentMap.put(key2, 2);

        key = null;

        key2 = null;

        System.out.println(studentMap);

        System.gc();

        System.out.println(studentMap);
    }
}
