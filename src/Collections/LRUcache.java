package Collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUcache<K, V> extends LinkedHashMap<K, V>
{
    private int capacity;

    public LRUcache(int capacity)
    {
        super(capacity, 0.75f, true);

        this.capacity = capacity;
    }

    protected boolean removeEldestEntry(Map.Entry<K, V> eldest)
    {
        return size() > capacity;
    }

    public static void main(String[] args)
    {
        LRUcache<String, Integer> studentMap = new LRUcache<>(3);

        studentMap.put("a", 1);

        studentMap.put("b", 2);

        studentMap.put("c", 3);

        System.out.println(studentMap);

        studentMap.put("d",4);

        System.out.println(studentMap);
    }
}
