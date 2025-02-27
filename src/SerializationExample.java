//If a parent class has implemented Serializable interface then child class doesn’t need to implement it but vice-versa is not true.
//Only non-static data members are saved via Serialization process.
//Static data members and transient data members are not saved via Serialization process. So, if you don’t want to save value of a non-static data member then make it transient.
//Constructor of object is never called when an object is deserialized.
//Associated objects must be implementing Serializable interface.

import java.io.*;

class Person implements Serializable{
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void display(){
        System.out.println("name "+ name + " age "+age);
    }
}

public class SerializationExample {
    public static void main(String[] args) {
        try{
            Person p = new Person("maitri",20);
            p.display();

            FileOutputStream fileOut = new FileOutputStream("person.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            //serialize object
            out.writeObject(p);
            out.close();
            fileOut.close();

            FileInputStream fileIn = new FileInputStream("person.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            //deserialization
            Person person = (Person) in.readObject();
            in.close();
            fileIn.close();
            person.display();

        }  catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
