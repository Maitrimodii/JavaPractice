//return type of parent method and child class method can be same or has covariant type
// for example if we have integer and number
//if dont want method to overriden then we can make that method final
//hierarchy for access specifer
//private -> default -> protected -> public it shoudld be from left to right
//Exception -> child classes of exception it should be from left to right

class ParentA{
    int a = 10;
    void display(){
        System.out.println("printA");
    }
    protected void display3(){
        System.out.println("display of parent");
    }
}
class ChildA extends ParentA{
    int b = 10;
        void display(){
        System.out.println("PrintB");
    }
    void display1(){
        System.out.println("PrintB 1");
    }
     public void display3(){
        System.out.println("display3 of child ");
    }//child class must have access specifer lesser then the parent one as it is protected we can have only public
}

public class MethodOverriding {
    public static void main(String[] args) {
        ParentA obj = new ParentA();
        ParentA obj2 = new ChildA();// it will look for only overridden method in child class and not found then call the parent class
        obj2.display();
        //System.out.println(obj.b); cannot access non overriden methods and varaible
        obj.display();//call the parent class overriden method
        ChildA obj1 = new ChildA();
        obj1.display();// if not present in child one then call parent one and can access parent class data also
    }
}
