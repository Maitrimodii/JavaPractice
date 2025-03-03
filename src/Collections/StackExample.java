//stack is a subclass of vector and so it is also synchronized

package Collections;

import java.util.LinkedList;
import java.util.Stack;

public class StackExample
{
    public static void main(String[] args)
    {
        var st = new Stack<Integer>();

        st.add(1);
        st.add(2);
        System.out.println(st.add(3));//returns true or false

        st.push(4);//O(1) //return pushed element
        st.push(5);
        st.push(2);

        System.out.println(st.push(5));

        System.out.println(st.peek());

        System.out.println(st.search(3));//O(n) //searches from top

        st.pop();//O(1) //return popped element
        System.out.println(st);

        //linkedlist as stack
        var stack = new LinkedList<Integer>();

        stack.addLast(2);
        stack.addLast(3);
        stack.addLast(4);//push
        stack.getLast();//peek
        stack.removeLast();//pop

        System.out.println(stack);

        //ArrayList as stack
        var stack2 = new LinkedList<Integer>();

        stack2.addLast(2);
        stack2.addLast(3);
        stack2.addLast(4);//push
        stack2.getLast();//peek
        stack2.removeLast();//pop

        System.out.println(stack2);
    }
}
