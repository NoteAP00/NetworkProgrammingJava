
public class TestIO {
    public static void main(String[] args) {
        try {
            System.out.println("Hello EnET(C) " + args[0] + " " + args[0].length());
            for (int i = 0; i < args.length; i++) {
                System.out.println("[" + args[i].length() + "]" + " Args " + i + " : " + args[i]);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
