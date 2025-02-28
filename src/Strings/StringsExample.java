package Strings;
//ways to create
//using string literal(static memory)
//using new keyword(heap memory)
//string buffer is thread safe but string builder is not
//in String which evaluated at compile time will be stored in scp and those which are evaluated at runtime will be stored in heap

public class StringsExample {
    public void stringPool(){
        String str = "hello";        // Literal, stored in the String Pool
        String str2 = "hello";       // Reuses the same reference from the pool
        System.out.println("using string literal str == str2" + (str == str2));   // true - same reference from pool

        System.out.println("str.equals(str2)"+ str.equals(str2));  // true - same content
        System.out.println("str.hashCode() == str2.hashCode()"+ (str.hashCode() == str2.hashCode()));  // true - same content

        String str1 = new String("hello");  // New object created in heap, outside String Pool
        String str3 = new String("hello"); // Another new object in heap and in heap it is pointing to string in string pool
        System.out.println("using new == "+ (str1 == str3));   // false - different references in heap

        System.out.println("str1.equals(str3)"+str1.equals(str3));  // true - same content
        System.out.println("str1.hashCode() == str3.hashCode()"+ (str1.hashCode() == str3.hashCode()));  // true - same content

        String str5 = new String("hello").intern();//explicitly store this in scp and refers this with scp string not with heap
        System.out.println("str5 and str" +(str5 == str));
    }
    public void stringVsStringbuffer(){
        String str1 = "hello";
        String str2 = str1 + "world";

        System.out.println("Using String:");
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
        System.out.println("str1 == str2: " + (str1 == str2));  // false, different objects in memory

        StringBuffer sb1 = new StringBuffer("hello");
        sb1.append("world");
        System.out.println("using string buffer");
        System.out.println("sb1"+sb1);
        System.out.println("sb1.toString():"+sb1.toString());
        System.out.println("sb1 == sb2" + (sb1 == sb1));
    }
    public static void main(String[] args) {
        StringsExample obj1 = new StringsExample();
        obj1.stringPool();
        obj1.stringVsStringbuffer();
    }
}
