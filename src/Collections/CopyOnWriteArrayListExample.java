//copy on write means it will create a new copy of the list when we try to modify the list
//This ensures that other threads can read the list without any issues
//This is useful when we have multiple threads reading the list and only a few threads modifying the list
//Read operations: fast and no locking is required
//write operations: new copy of list is created and the element is added to the new list and the reference is updated

package Collections;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample
{
    public static void main(String[] args)
    {
        var list = new CopyOnWriteArrayList<Integer>();

        list.add(1);

        list.add(2);

        list.add(3);

        list.add(4);

        list.add(5);

        for (var integer : list)
        {
            System.out.println(integer);
        }
    }
}
