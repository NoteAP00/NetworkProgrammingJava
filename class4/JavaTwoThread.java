import java.io.*;
public class JavaTwoThread implements Runnable{
    int from,end,result=0;
    long sleep;
    public JavaTwoThread(int from , int end , long sleep){
        this.from = from;
        this.end = end;
        this.sleep = sleep;
    }
        
    public void run() {
        for (int i = from; i <= end; i++) {
            result += i;
        }try {
                Thread.sleep(sleep);
            } catch (Exception e) {
                // TODO: handle exception
            }
    }
    public int result(){
        return result;
    }

    public static void main(String[] args) {
        JavaTwoThread s1 = new JavaTwoThread(1,5000,5000);
        JavaTwoThread s2 = new JavaTwoThread(5001,10000,10000);
        Thread t1 = new Thread(s1);
        Thread t2 = new Thread(s2);
        int sum = 0;
        try {
            t1.start(); t2.start();
            t1.join(); t2.join();
            sum = s1.result()+s2.result();
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("Result = " + sum);
    }
}