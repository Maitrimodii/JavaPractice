//stack is a subclass of vector and so it is also synchronized

package Collections;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        st.add(1);
        st.add(2);
        System.out.println(st.add(3));//returns true or false

        st.push(4);//O(1) //return pushed element
        st.push(5);
        st.push(2);

        System.out.println(st.push(5));

        System.out.println(st.peek());

        System.out.println(st.search(3));//O(n) //searches from top

    }
}
