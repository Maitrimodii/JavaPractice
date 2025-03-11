package Threading.InterThreadCommunication;

class Queue {
    int data;
    boolean produced = false;

    public synchronized void produce(int value) throws InterruptedException {
        while (produced) {
            wait();  // Wait until the consumer consumes the data
        }
        data = value;
        System.out.println("Produced: " + data);
        produced = true;
        notify();  // Notify the consumer to consume
    }

    public synchronized void consume() throws InterruptedException {
        while (!produced) {
            wait();  // Wait until producer produces data
        }
        System.out.println("Consumed: " + data);
        produced = false;
        notify();  // Notify the producer to produce again
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        Queue queue = new Queue();

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    queue.produce(i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    queue.consume();
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
