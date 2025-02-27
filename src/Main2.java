class Test3{
    public void execute(){
        execute1();
        System.out.println("1");
    }
    private void execute1(){
        try{
            execute2();
            System.out.println("2");
        }catch(Exception e){
            System.out.println("Hello");
        }
    }
    private void execute2(){
        execute3();
        System.out.println("3");
    }
    private void execute3(){
        int b = 10/0;
        System.out.println("4");
    }
}
class Main2 {
    //String s;
    // final static int i = 1;
    // final static Main x = null;
    //final static String s = "james";

    private static void hello(){
        System.out.println("helo is called");
    }
    private void hello1(){
        System.out.println("hello1");
    }
    public static void main(String[] args) {
        Test3 x = new Test3();
        x.execute();

        //Boolean b = new Boolean("True");
        String s = "";
        String s1 = "";

        //System.out.println(s1.equals(s));
        //System.out.println(b);
        Main2 obj = new Main2();
        obj.hello1();

        Main2.hello();

    }
}