package Files;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void appendToFile(String content, String name) throws IOException {
        FileWriter fileWriter = new FileWriter(name,true);
        fileWriter.append(content);
        fileWriter.flush();
        fileWriter.close();
    }

    public static void main(String[] args){
        try {
            appendToFile("hello", "example.txt");
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
