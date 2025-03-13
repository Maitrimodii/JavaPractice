package Threading.Locks;

import java.util.concurrent.Semaphore;

class ParkingLot {
    private final Semaphore semaphore;

    public ParkingLot(int slots) {
        this.semaphore = new Semaphore(slots); // Allows only 'slots' number of cars at a time
    }

    public void parkCar(String car) {
        try {
            System.out.println(car + " is trying to park.");
            semaphore.acquire(); // Decrease available slots
            System.out.println(car + " parked.");
            Thread.sleep(2000); // Simulate parking time
            System.out.println(car + " is leaving.");
            semaphore.release(); // Increase available slots
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class SemaphoreExample {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(3); // Only 3 parking slots

        Runnable car = () -> {
            String carName = Thread.currentThread().getName();
            parkingLot.parkCar(carName);
        };

        for (int i = 1; i <= 6; i++) {
            new Thread(car, "Car-" + i).start();
        }
    }
}
