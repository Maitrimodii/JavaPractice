package Collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample
{
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> studentMap =  new LinkedHashMap<>(11, 0.5f, true);

        studentMap.put("a", 4);

        studentMap.put("b", 2);

        studentMap.put("c", 3);

        studentMap.get("c");

        for(Map.Entry<String, Integer> entry : studentMap.entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
