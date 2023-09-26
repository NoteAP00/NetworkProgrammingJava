import java.net.*;
import java.io.*;
public class Client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1", 23410);
            BufferedReader br = new BufferedReader(
                                new InputStreamReader(
                                s.getInputStream()));
            PrintWriter pw = new PrintWriter(s.getOutputStream());
            if(!args[0].equals(null)){
                for(int i = 0; i < args.length && i < 3; i++){
                    pw.println(args[i]);
                    pw.flush();
            }

            }
            
            String msg = br.readLine();

            System.out.println(msg);

            br.close();
            pw.close();
            s.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
