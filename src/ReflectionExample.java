import java.lang.reflect.*;

class Employee{

    private static String name;
    private static int age;

    Employee(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    private void display()
    {
        System.out.println("name "+name+" age"+age);
    }

    private static void show()
    {
       // Person obj = new Person("maitri",20);
        System.out.println("name "+name+" age"+age);
    }

}
public class ReflectionExample {
    public static void main(String[] args)
    {
        try{
            Employee emp = new Employee("alice",20);

            //loads class dynamically
            var clazz = Class.forName("Employee");
            System.out.println("class "+clazz);

            System.out.println("list methods");

            for(Method method : clazz.getDeclaredMethods())
            {
                System.out.println(method.getName());
            }

            System.out.println("list fields");
            for(Field field : clazz.getDeclaredFields())
            {
                System.out.println(field.getName());
            }

            System.out.println("list constructor");
            for(Constructor<?> constructor: clazz.getDeclaredConstructors())
            {
                System.out.println(constructor.getName());
            }

            Field field = clazz.getDeclaredField("name");
            field.setAccessible(true);

            //modify the private field
            field.set(emp,"maitri");

            System.out.println(field.get(emp));

            Method method = clazz.getDeclaredMethod("display");
            method.setAccessible(true);

            //to invoke method
            method.invoke(emp);

            //to invoke static method
            Method methodStatic = clazz.getDeclaredMethod("show");
            methodStatic.setAccessible(true);
            methodStatic.invoke(null);

        }catch(Exception exception){
            System.out.println(exception);
        }
    }
}
