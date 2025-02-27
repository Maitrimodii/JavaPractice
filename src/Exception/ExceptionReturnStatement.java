package Exception;

class ExceptionHiding{
    //final static int a; //throws compilation error
    public static void main() {
        try{
            int i = 5/0;
        }
//        catch (ArithmeticException e) {
//            //e = new NullPointerException("Exception from catch");
//            throw e;
//        }
        finally {
            throw new ArithmeticException("Exception from finally");//hides exception from catch
        }
    }
}
public class ExceptionReturnStatement {
    public int method1(){
        try{
            int i = 10/0;
            System.out.println("try block");
            //System.exit(0);
            return 100;
        } catch (Exception e) {
            System.out.println("catch block");
            return 200;
        }finally {
            System.out.println("finally");
           // return 400;
        }
    }
    public static void main(String[] args) {
        ExceptionReturnStatement obj = new ExceptionReturnStatement();
        System.out.println(obj.method1());

//        ExceptionHiding obj1 = new ExceptionHiding();
//        try {
//            obj1.main();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    }
}
