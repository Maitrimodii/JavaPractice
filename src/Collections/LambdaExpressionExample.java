package Collections;

interface MyInterface
{
     int addition(int a,int b);
}
public class LambdaExpressionExample
{
    public static void main(String[] args)
    {
        Thread t1 = new Thread(() ->
        {
            System.out.println("Task is running");
        });

        MyInterface addition = (a,b) ->
        {
            return a+b;
        };

        System.out.println(addition.addition(10,20));

        //
        //OR
        // MyInterface addition = (a,b) -> a+b;

        int x = 20;
        //x = 30; //Local variable x defined in an enclosing scope must be final or effectively final

        MyInterface PrintNumber =((a, b) ->
        {
            System.out.println(x);
            //x = 30; //Local variable x defined in an enclosing scope must be final or effectively final
           return a + x;
        });

        PrintNumber.addition(10,20);
    }
}

