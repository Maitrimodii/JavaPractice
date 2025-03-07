//intial capacity 16
//new capacity =  (current capacity *2 ) + 2
package Strings;

public class StringBuilderMethods {
    public static void main(String[] args) {
        // Create a StringBuilder object
        StringBuilder sb = new StringBuilder("Hello");

        // Append a string
        sb.append(" World");  // Adds " World" at the end of "Hello"
        System.out.println(sb); // Output: Hello World

        // Insert a string at specific position
        sb.insert(6, "Beautiful ");  // Inserts "Beautiful " at index 6
        System.out.println(sb); // Output: Hello Beautiful World

        // Delete part of the string
        sb.delete(6, 17);  // Deletes from index 6 to 17 (removes "Beautiful ")
        System.out.println(sb); // Output: Hello World

        // Reverse the string
        sb.reverse();  // Reverses the content
        System.out.println(sb); // Output: dlroW olleH

        // Convert StringBuilder to String
        String result = sb.toString();  // Converts StringBuilder to String
        System.out.println("Converted to String: " + result);  // Output: dlroW olleH
    }
}
