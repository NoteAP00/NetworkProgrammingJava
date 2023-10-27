
import java.io.*;
import java.net.*;

class Client {

    public static void main(String[] args) {
        try {
            if (args[0].equals("add")) {
                if (args.length != 3) {
                    System.out.println("number of parameters is incorrect");
                    return;
                }
                String name = args[1];
                int score;
                try {
                    score = Integer.parseInt(args[2]);
                } catch (Exception e) {
                    System.out.println("score must be a number");
                    return;
                }
                Socket s = new Socket("127.0.0.1", 56789);
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                PrintWriter pw = new PrintWriter(s.getOutputStream());
                pw.println("add");
                pw.println(name);
                pw.println(score);
                pw.flush();
                String readLine = br.readLine();
                if (readLine.equals("OK")) {
                } else {
                    System.out.println(readLine);
                }
                s.close();
                br.close();
                pw.close();
            } else if (args[0].equals("grade")) {
                if (args.length != 2) {
                    System.out.println("number of parameters is incorrect");
                    return;
                }
                String name = args[1];
                Socket s = new Socket("127.0.0.1", 56789);
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                PrintWriter pw = new PrintWriter(s.getOutputStream());
                pw.println("grade");
                pw.println(name);
                pw.flush();
                String readLine = br.readLine();
                System.out.println(readLine);
                s.close();
                br.close();
                pw.close();
            } else {
                System.out.println("incorect command");
            }
        } catch (Exception e) {
            System.out.println("number of parameters is incorrect");
        }
    }
}
