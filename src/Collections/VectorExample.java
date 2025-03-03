//same as ArrayList but it is synchronized
//for thread safe collections, copy on write array list is better than vector
//vector is legacy class
//it is slow and not fail fast


package Collections;

import java.util.Arrays;
import java.util.Vector;

public class VectorExample
{
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<Integer>(4,3);
        vector.add(1);//O(1)
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(null);

        System.out.println(vector.capacity());

        vector.add(2);

        System.out.println(vector.capacity());//4+3=7

        System.out.println(vector.contains(4));//O(n)
        System.out.println(vector.isEmpty());
        vector.remove(4);//O(n)

        System.out.println(vector);
        vector.addAll(Arrays.asList(5,6,7,8));//O(n)

        System.out.println(vector);

    }
}
