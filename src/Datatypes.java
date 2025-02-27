public class Datatypes {
    public static void types(){

        byte by = 10;

//        size = 1byte
//        used to save memory in large arrays
//        range [-128 to 127]

//        byte b = 127;
//        b++;
//        System.out.println("value after overflow " + b);
//        if a byte exceeds its maximum value (127), it will wrap around to the minimum value (-128).

//        byte a = 10;
//        byte b = 20;
//        byte c = (byte) (a + b); // Explicit type casting is needed else give result in int

        char ch = 'a';

//        size = 2 byte because uses unicode system and default value is '/u0000'

        short sh = 20; //size 2byte
        int in = 30; // size 4byte default value 0
        long l = 1010L;  //size 8byte default value 0
        float fl = 0.1f; // size 4byte, default 0.0
        double dl = 0.0d; //size 8byte, default 0.0
        boolean bl = false; //default false size ,1bit
    }

    public static void main(String[] args) {
        types();
    }

}
