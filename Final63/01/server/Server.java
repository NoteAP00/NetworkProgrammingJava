// Server.java
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.*;
import java.net.*;

class Server implements Runnable {

    Socket s = null;
    private static volatile HashMap<String, Integer> stdScore = new HashMap<String, Integer>();

    public Server(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            Scanner sc = new Scanner(s.getInputStream());
            PrintStream ps = new PrintStream(s.getOutputStream());
            String str = sc.nextLine();
            if (str.equals("add")) {
                try {
                    String name = sc.nextLine();
                    int score = sc.nextInt();
                    stdScore.put(name, score);
                    ps.println("OK");
                } catch (Exception e) {
                    ps.println("score must be a number");
                }
            } else if (str.equals("grade")) {
                String name = sc.nextLine();
                if (stdScore.containsKey(name)) {
                    int score = stdScore.get(name);
                    if (score > 100) {
                        ps.println("Fabulous : " + score);
                    } else if (score >= 80) {
                        ps.println("Good : " + score);
                    } else if (score >= 50) {
                        ps.println("Pass : " + score);
                    } else if (score < 50 && score >= 0) {
                        ps.println("Fail : " + score);
                    } else {
                        ps.println("Fabulous : " + score);
                    }
                } else {
                    ps.println();
                }
            } else {
                ps.println("incorrect command");
            }
            ps.flush();
            ps.close();
            sc.close();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            ServerSocket serv = null;
            ExecutorService es = Executors.newFixedThreadPool(20);
            int port = 56789;
            try {
                serv = new ServerSocket(port);
                while (true) {
                    Socket cs = serv.accept();
                    Server sv = new Server(cs);//
                    es.execute(sv);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
