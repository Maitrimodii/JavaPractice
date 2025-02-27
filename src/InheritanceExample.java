class Base {
     int id = 1000; //Line n1

    Base() {
        System.out.println("after returning from object method");
        Base(); //Line n2
        System.out.println("base method from constructor");
    }

     void Base() { //Line n3
        System.out.println("base method called" + id);
        System.out.println(id); //Line n4
    }
}

class Derived extends Base {
    int id =2000 ; //Line n

    Derived() {
        System.out.println("child constructor");
    } //Line n6

     void Base() { //Line n7
        System.out.println("base method of child class called " + id);
        System.out.println(id); //Line n8
    }
}

public class InheritanceExample {
    public static void main(String[] args) {
        final int id ; //Line n
        Base base = new Derived(); //Line n9
        base.Base();
    }
}