package Exception;
//if throw checked checked exception in method and it is not handled by try catch block
//then use throws keyword in that method
class MyCustomException extends Exception{//will create checked Exception for unchecked Exception extend RuntimeException
    public MyCustomException(String m){
        super(m);
    }
}
public class CustomException {
    public static void main(String[] args){
        try {
            throw new MyCustomException("Mycustom Exception is called");
        }catch(MyCustomException e){
            System.out.println("exception triggered"+e.getMessage());
        }
        catch(ArithmeticException e){
            System.out.println("fdsds");
        }//only specify those checked exception that will be handled in try block
    }
}
