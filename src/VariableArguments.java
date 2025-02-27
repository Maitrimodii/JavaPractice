//cannot have two varargs in method
//variable arguments should always be last in parameters

class VarArgsExample{
    static void fun(String s, int... a){
        System.out.println(s);
        for(int num : a){
            System.out.println(num);
        }
    }
}
public class VariableArguments {
    public static void main(String[] args) {
        VarArgsExample.fun("hello",1,2,3,4,5);
    }
}

