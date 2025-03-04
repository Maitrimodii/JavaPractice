package Collections;

import java.util.*;

public class NavigableMapExample
{
    public static void main(String[] args){
        SortedMap<String, Integer> map = new TreeMap<>();

        map.put("d", 10);
        map.put("b", 2);
        map.put("c", 30);

        System.out.println(map);
    }
}
