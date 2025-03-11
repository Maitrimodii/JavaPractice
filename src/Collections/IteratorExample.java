package Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorExample
{
    public static void main(String[] args)
    {
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);

        list.forEach(System.out::println);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer number = iterator.next();
            if(number % 2 == 0){
                iterator.remove();
            }
            System.out.println(iterator.next());
        }

//         throws concurrent modification
//        for(Integer number : list){
//            if(number % 2 == 0){
//                list.remove(number);
//                System.out.println(number);
//            }
//        }
    }
}
