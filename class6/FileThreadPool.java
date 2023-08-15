import java.io.*;
import java.util.concurrent.*;

public class FileThreadPool implements Runnable {
    int num;
    public FileThreadPool (int num){
        this.num = num;
    }
    public void run() {
        try {
            Thread.sleep(200);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println(num + " -> " + (int)Math.pow(num, 2));
    }

    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                throw new ArrayIndexOutOfBoundsException();
            }
            String dir = args[0];
            String msg;
            File dirFile = new File(dir);
            FileInputStream fin = new FileInputStream(dirFile);
            ExecutorService es = Executors.newFixedThreadPool(3);
            InputStreamReader ir = new InputStreamReader(fin);
            BufferedReader br = new BufferedReader(ir);
            while((msg = br.readLine()) != null){
                int num = Integer.parseInt(msg);
                FileThreadPool f = new FileThreadPool(num);
                es.execute(f);
            }
            es.shutdown();
            br.close();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Usage : java FileThreadPool <text file [*.txt , etc.] >");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}