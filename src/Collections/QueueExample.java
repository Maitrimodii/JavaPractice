//ArrayBlockingQueue is thread safe
//ArrayBlockingQueue does not allow null values
//ArrayBlockingQueue // put() -> blocks if queue is full
//ArrayBlockingQueue // take() -> blocks if queue is empty

package Collections;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueExample
{
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        System.out.println(queue.size());
        //System.out.println(queue.remove()); this will throw no such element exception
        System.out.println(queue.poll());//this will return null

        queue.add(1);
        queue.add(2);

        queue.add(null);

        System.out.println(queue.remove());

        System.out.println(queue.poll());

        System.out.println(queue);


        Queue<Integer> queue2 = new ArrayBlockingQueue<>(2);

        queue2.add(1);

        queue2.add(2);

        //add(), remove() and element() throws exception if operation not successful
        //offer() will return false
        //poll() will return null

        //queue2.add(3);//this will throw illegal state exception

        queue2.offer(3);//this will return false if not added if added return true

        System.out.println(queue2);
    }
}
