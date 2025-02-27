package Exception;

class Addition{
    public void add(){
        int a = 10;
        int b = 0;
        int c = a/b;

        throw new ArithmeticException("division by zero");
    }
}
public class Throw {
    public static void main(String[] args) {
        Addition obj = new Addition();
        try{
            obj.add();
        }catch (ArithmeticException e){
            System.out.println("caller");
        }//if finally block is used in place of catch then default handler will handle it
    }
}
