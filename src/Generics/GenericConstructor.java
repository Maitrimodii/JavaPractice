package Generics;

//provides type safety and reusability
//constructor does not support wildcard
//<?super T> can accept T or superclass of T
//super can only be used with wildcard
//generics can accept only non-primitive types
//cannot use instanceof with generics
//generic array and object are not allowed

public class GenericConstructor {
    public <T extends Integer> GenericConstructor(T val){
        System.out.println(val);
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
