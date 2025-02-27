public class ShutdownHook {
    public static void main(String[] args) {

        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            public void run(){
                System.out.println("Shutdown hook is called");
            }
        });

        System.out.println("program is terminating");
    }
}
