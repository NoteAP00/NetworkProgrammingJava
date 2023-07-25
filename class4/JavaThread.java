import java.io.*;

public class JavaThread extends Thread {
    int count;
   public JavaThread (int count){
    this.count = count;
   }
   
    public void run(){
        System.out.println(count + "\t HelloWorld");

    }
    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                throw new ArrayIndexOutOfBoundsException();
            }
            JavaThread []HelloWorld = new JavaThread[Integer.parseInt(args[0])];
            for (int i = 0; i < HelloWorld.length; i++) {
                HelloWorld[i] = new JavaThread(i);
                HelloWorld[i].start();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}