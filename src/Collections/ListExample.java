//for sorting it takes O(nlogn) time complexity and uses tim sort
//for add, remove, get, set it takes O(1) time complexity
//for contains it takes O(n) time complexity
//for addAll it takes O(n) time complexity
//tim sort : - uses insertion sort for smaller array and merge sort for larger array
//not thread -safe

package Collections;

import java.util.*;

class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }
}

public class ListExample {
    public static void main(String[] args) throws Exception{
        var list = new ArrayList<Integer>(4);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(6);
        list.add(7);
        list.add(null);

        list.set(0,0);
        System.out.println(list);

        list.remove(Integer.valueOf(2));//to remove value 2
        System.out.println(list);
        System.out.println(list.get(2));
        System.out.println(list.size());
        System.out.println(list.contains(3));

        for (var x : list) {
            System.out.println(x);
        }


        var field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        var elementData = (Object[]) field.get(list);
        System.out.println("capacity of list " + elementData.length);

        var list4 = new ArrayList<Integer>();
        list4.add(10);
        var elementData2 = (Object[]) field.get(list4);
        System.out.println("capacity of list " + elementData2.length);

        list.remove(2);

        ((ArrayList<Integer>) list).trimToSize();

        elementData = (Object[]) field.get(list);

        System.out.println("capacity of list " + elementData.length);

        List<String> list1 = Arrays.asList("Tuesday", "Monday", "Wednesday");

        System.out.println(list1.getClass().getName());

        String[] arr = {"Monday", "Tuesday", "Wednesday","Sun","Sat"};

        List<String> list2 = Arrays.asList(arr);

        System.out.println(list2.getClass().getName());

        //Collections.sort(list2);

        System.out.println(list2);

        //list2.sort(new StringLengthComparator());
        //list2.sort((a,b) -> a.length() - b.length()); // using lambda expression
        System.out.println("using lambda function "+list2);

        Comparator<String> comparing = Comparator.comparing(String::length); // using method reference
        Comparator<String> comparing1 = Comparator.comparing(String::length).thenComparing(String::compareTo); // using method reference

        System.out.println("using method reference  "+list2);

        //list2.add("Thursday"); // This will throw UnsupportedOperationException reason: because Arrays.asList()
        // returns a fixed-size list backed by the specified array
        // arrays is final and does not override remove and add method.
        //list2.remove(0); // This will throw UnsupportedOperationException
        list2.set(0, "Sunday"); // modification is possible
        System.out.println(list2);


        List<Integer> list3 = List.of(1, 2, 3, 4, 5);
        //list3.add(6); // This will throw UnsupportedOperationException
        //list3.remove(4); // This will throw UnsupportedOperationException
        //list3.set(0, 10); // This will throw UnsupportedOperationException

        list.addAll(list3);
        //list1.addAll(list);// This will throw UnsupportedOperationException
        System.out.println(list);

        //Collections.sort(list);

        System.out.println(list);

        Integer[] nums = list.toArray(new Integer[5]);
        for(var x : list){
            System.out.println(x);
        }
    }
}