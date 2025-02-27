package Constructor;

import java.util.Arrays;

public class CopyConstructor {
    int i;
    String s;
    int[] arr;

    // Constructor to initialize the fields
    CopyConstructor(int i, String s, int[] arr) {
        this.i = i;
        this.s = s;
        this.arr = arr;
    }

    // Copy Constructor (Shallow copy by default)
    CopyConstructor(CopyConstructor c) {
        this.i = c.i;
        this.s = c.s;
        this.arr = c.arr; // Shallow copy of the array
        // For Deep Copy, you can uncomment below lines:
        // this.arr = new int[c.arr.length];
        // for (int i = 0; i < c.arr.length; i++) {
        //     this.arr[i] = c.arr[i];
        // }
    }

    // Method to display object details
    void display() {
        System.out.println(this.i + " " + this.s + " " + Arrays.toString(this.arr));
    }

    public static void main(String[] args) {
        // Creating first object with initial values
        CopyConstructor c1 = new CopyConstructor(10, "purvik", new int[]{1, 2, 3});

        // Creating second object using copy constructor (shallow copy by default)
        CopyConstructor c2 = new CopyConstructor(c1);

        // Displaying both objects
        c1.display();
        c2.display();

        // Modifying c2's fields
        c2.i = 20;
        c2.s = "naman";
        c2.arr[0] = 5;

        // Displaying after modifying c2
        c1.display();
        c2.display();

        // Shallow copy of all fields from c2 to c3
        CopyConstructor c3 = c2;

        // Displaying c3 (which is now pointing to c2)
        c3.display();

        // Modifying c3's fields
        c3.s = "heet";
        c3.arr[0] = 7;

        // Displaying after modifying c3 (affects c2 since c3 is a reference to c2)
        c1.display();
        c2.display();
        c3.display();

        // Comparing c1 and c2 using equals method
        System.out.println(c1.equals(c2));
        System.out.println(c2.equals(c3));
    }
}
