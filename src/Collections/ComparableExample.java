package Collections;

import java.util.ArrayList;
import java.util.List;

class Person implements Comparable<Person>
{
    private String name;
    private int age;

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public int compareTo(Person p)
    {
        return Double.compare(age, p.age);
    }

    public String toString()
    {
        return name + " : " + age;
    }

}
public class ComparableExample
{
    public static void main(String[] args)
    {
        List<Person> listPerson = new ArrayList<>();
        listPerson.add(new Person("Alice", 25));
        listPerson.add(new Person("Maitri", 40));
        listPerson.add(new Person("Bob", 20));
        listPerson.add(new Person("Suhana", 30));

        System.out.println(listPerson);

        listPerson.sort(null);

        System.out.println(listPerson);
    }
}
