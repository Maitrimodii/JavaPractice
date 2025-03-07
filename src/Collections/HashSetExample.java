//set is collection that cannot contain duplicate elements
//faster operations than list
//HashSet is implemented using a hash table
//HashSet does not maintain insertion order
//HashSet allows null values
//HashSet is non synchronized
//HashSet is fail fast
//HashSet is not thread safe
// key (k) -> the element added to the hashset
// value (v) -> the dummy constant PRESENT

package Collections;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample
{
    public static void main(String[] args)
    {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        System.out.println(set.add(4));//duplicates will be ignored and will return false


        set.remove(4);

        Integer[] numbers = set.toArray(new Integer[0]);
        System.out.println("Converted HashSet to Array: ");
        for (Integer num : numbers) {
            System.out.println(num);
        }

    }
}
