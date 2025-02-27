package Files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputStreamExample {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("example.txt"))){

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                // Simulate modification to the file// Wait for a second
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
