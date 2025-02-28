record Staff(String name, int age){
    //record class automatically generate getter and setter method
    //automatically generate toString(), equals(), hashcode()
    //fields are by default final
    //no need to manually define boilerplate
    //cannot extend another class but can implement interface
}
public class RecordClass {
    public static void main(String[] args) {
        Staff staff = new Staff("Maitri",20);


        //accessing fields
        System.out.println("name : "+staff.name());
        System.out.println("age : "+staff.age());

        Staff staff1 = new Staff("Maitri",20);
        System.out.println(staff.equals(staff1));

        System.out.println(staff);
    }
}
