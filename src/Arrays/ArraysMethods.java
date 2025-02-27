package Arrays;
import java.util.Arrays;

public class ArraysMethods {
    public static void main(String[] args) {
        int intArr[] = {10,20,30,40};
        int intArr1[] = {40,50,60};
        int clonedArray[] = intArr.clone();

        System.out.println(intArr == intArr1);
        System.out.println(intArr == clonedArray);
        System.out.println(Arrays.compare(intArr,clonedArray));// for checking equality of element in single dimensional array
        System.out.println(Arrays.compare(intArr,intArr1));


        int arr1[][] = {{10, 20, 30}, {10, 20, 30}};
        int arr2[][] = arr1.clone(); // Cloning 2D array

        System.out.println(Arrays.deepEquals(arr1, arr2)); // true for checking equality in multidimensional array

        // Checking if arr1 and arr2 point to the same nested arrays
        System.out.println(arr1 == arr2); // false (Different top-level array)
        System.out.println(arr1[0] == arr2[0]); // true (Same inner array reference)
        System.out.println(arr1[1] == arr2[1]); // true (Same inner array reference)

        int[] arr3 = {10, 23, 33, 50,60};
        int[] arr4 = {10, 23, 33};

        // checks the first element which is not equal and return -1
        // if all elements of other array are equal but not length then return length of first - length of second
        System.out.println(Arrays.compare(arr3, arr4));  // Output: 2
        System.out.println(Arrays.spliterator(arr3, 1, 3));
    }
}
