package Exception;

public class ExceptionHandling  {

    public static void main(String[] args) throws ClassNotFoundException{
        System.out.println("hello guys");
        ExceptionHandling obj = new ExceptionHandling();
        //compile successfully but will show error in runtime error
//        try{
//            obj.checking();
//        }catch (ClassNotFoundException e){
//            System.out.println(e);
//        }
    }

    //if not handle using try catch block in current method then check in caller method
    public void checking() throws ClassNotFoundException{
        Class.forName("com.example.NonExistentClass"); // This class does NOT exist
        System.out.println("Class loaded successfully!");
    }
}
