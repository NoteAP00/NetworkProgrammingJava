import java.net.*;
import java.io.*;
public class Server3 {
   public static void main(String[] args) {
    ServerSocket servSocket = null;
    try {
        servSocket = new ServerSocket(30000);
    } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
    }

    while(true){
        try {
            Socket s = servSocket.accept();
            BufferedReader br = new BufferedReader(
                            new InputStreamReader(
                            s.getInputStream()));
            PrintWriter pw = new PrintWriter(s.getOutputStream());
            String sleep = br.readLine();
            long sleepTime = Long.parseLong(sleep);
            try {
                Thread.sleep(sleepTime*1000);
            } catch (Exception se) {
                // TODO: handle exception
            }
            pw.println("OK");
        pw.flush();
        br.close();
        pw.close();
        s.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
   }
}

