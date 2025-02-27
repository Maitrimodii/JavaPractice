class TypesOfInstance {
    public static void main(String[] args) {
        Accessing obj = new Accessing();
        obj.get_num();
        obj.set_num();
    }
}
class Accessing{
    private int num = 20;

    public void get_num(){
        System.out.println("num "+ num);
    }
    public void set_num(){
        System.out.println("num "+(++num));
    }
}
