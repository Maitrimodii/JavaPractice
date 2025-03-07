package Collections;

interface MyInterface
{
     int addition(int a,int b);
}
public class LambdaExpressionExample
{
    Thread t1 = new Thread(() ->
    {
        System.out.println("Task is running");
    });

    MyInterface addition = (a,b) ->
    {
            return a+b;
    };
    //
    //OR
    // MyInterface addition = (a,b) -> a+b;
}

