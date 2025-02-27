package Generics;

import java.util.Arrays;
import java.util.List;

class Box<T extends Number>{
    public T value;

    public T getValue(){
        return value;
    }

    public void setValue(T value, List<?> c){
        this.value = value;
    }
}

public class GenericsClass {
    public static void main(String[] args) {
        Box<Integer> box = new Box<>();
        int i = box.getValue();
        System.out.println(i);
        box.setValue(1, Arrays.asList("hi",2));

    }

}
