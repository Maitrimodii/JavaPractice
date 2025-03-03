package Collections;

public class CopyOnWriteArrayList {
    public static void main(String[] args) {
        java.util.concurrent.CopyOnWriteArrayList<Integer> list = new java.util.concurrent.CopyOnWriteArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
