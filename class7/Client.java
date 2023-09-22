import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) {
        try {
            if (args.length > 1 && args.length < 4) {
                Socket s = new Socket("127.0.0.1", 23410);
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(
                                s.getInputStream()));
                PrintWriter pw = new PrintWriter(s.getOutputStream());
                for (int i = 0; i < args.length; i++) {
                    pw.println(args[i]);
                    pw.flush();
                }
                if (args.length < 3) {
                    pw.println("0");
                    pw.flush();
                }
                String msg;
                while ((msg = br.readLine()) != null) {
                    System.out.println(msg);
                }
                pw.close();
                br.close();
                s.close();
            } else {
                System.out.println("Command not found");
            }

        } catch (Exception e) {}

    }
}
