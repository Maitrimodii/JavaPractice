//uses separate locks for the producer(adding elements) and consumer(removing elements)
//add() blocks if queue is full
//remove() blocks if queue is empty


package Collections;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueExample
{
    public static void main(String[] args) {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(2);//if capacity is added then cannot add more
        //than capacity elements and if not provided then consider it has Integer.MAX_VALUE

        queue.add(1);
        queue.add(2);
        queue.add(3);// this will throw exception
        System.out.println(queue.peek());

        queue.remove();

        System.out.println(queue);
    }
}
