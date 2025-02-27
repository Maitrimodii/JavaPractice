package Exception;

public class ChainedException {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;

        try{
            System.out.println(a/b);
        }catch (ArithmeticException e){
            System.out.println("exception occuered");

            e.initCause(new RuntimeException("Error has occured during runtime",e));
            throw e;
        }
    }
}
