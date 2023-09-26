import java.net.*;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.*;

public class Server implements Runnable {
    Socket s = null;
    HashMap<String, String> data = new HashMap<String, String>();

    public Server(Socket s) {
        this.s = s;
    }

    public void run() {
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            s.getInputStream()));
            PrintWriter pw = new PrintWriter(s.getOutputStream());
            String command = br.readLine();
            String id, name;
            switch (command) {
                case "add":
                    id = br.readLine();
                    name = br.readLine();
                    data.put(id, name);
                    pw.println("OK");
                    break;
                case "search":
                    id = br.readLine();
                    String ans = data.get(id);
                    if (ans.equals(null)){
                        pw.println("N/A");
                    } else {
                        pw.println(ans);
                    }
                    break;
                default:
                    pw.println("Command not found");
                    break;
            }
            
            pw.flush();
            br.close();
            pw.close();
            s.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void main(String[] args) {
        ServerSocket serv = null;
        ExecutorService es = Executors.newFixedThreadPool(15);
        try {
            serv = new ServerSocket(23410);
        } catch (Exception e) {
            // TODO: handle exception
            System.exit(1);
        }
        while (true) {
            try {
                Socket s = serv.accept();
                ServerTP3 st = new ServerTP3(s);
                es.execute(st);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
