//part of the queue interface
//orders element based on their natural ordering(for primitives lowest first)
//or by a comparator
//does not allow null values
//implemented as min heap by default
package Collections;


import java.util.PriorityQueue;

public class PriorityQueueExample
{
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(5);
        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(4);//O(logn)

        System.out.println(pq);//not sorted

//        while(!pq.isEmpty()){
//            System.out.println(pq.poll());
//        }


    }
}
