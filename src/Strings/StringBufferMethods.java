package Strings;

//extends object class
// implements serializable,  appendable, charsequence
public class StringBufferMethods {
    public void methods(){
        StringBuffer sb = new StringBuffer("hello");

        sb.append("world");
        System.out.println("append world " + sb);

        sb.insert(5, " ");
        System.out.println("insert " + sb);

        sb.delete(5,6);
        System.out.println("delete 5 th char " + sb);

        sb.setLength(0); //clear the string Builder

        sb.reverse();
        System.out.println("reverse string " + sb);
    }

    public static void main(String[] args) {
        StringBufferMethods obj = new StringBufferMethods();
        obj.methods();
    }
}
