import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileServer implements Runnable {
    Socket s = null;

    public FileServer(Socket s) {
        this.s = s;
    }

    public void run() {
        try {
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            PrintWriter pw = new PrintWriter(out);
            String[] command = null;
            String line = br.readLine();
            if ("upload".equals(line) || "download".equals(line)) {
                command = new String[2];
                command[0] = line;
                command[1] = br.readLine();
                if ("upload".equals(command[0])) {
                    try {
                        String filename = command[1];
                        File f = new File(filename);
                        if (f.exists()) {
                            f.delete();
                            f = new File(filename);
                        }
                        FileOutputStream fout = new FileOutputStream(f);
                        byte[] b = new byte[65536];
                        int size;
                        while ((size = in.read(b)) > 0) {
                            fout.write(b, 0, size);
                        }
                        fout.flush();
                        fout.close();
                    } catch (Exception e) {
                        pw.println("error");
                    }
                } else {
                    try {
                        String filename = command[1];
                        File f = new File(filename);
                        if (!f.exists() || !f.isFile()) {
                            pw.println(filename + " not found");
                            pw.flush();
                            return;
                        } else {
                            pw.println("OK");
                            pw.flush();
                            FileInputStream fin = new FileInputStream(f);
                            byte[] buffer = new byte[65536];
                            int size;
                            while ((size = fin.read(buffer)) > 0) {
                                out.write(buffer, 0, size);
                            }
                            out.flush();
                        }
                    } catch (Exception e) {
                        pw.println("error");
                    }
                }
            } else if ("list".equals(line)) {
                try {
                    System.out.println("list");
                    File f = new File("./");
                    String[] filename = f.list();
                    for (int i = 0; i < filename.length; i++) {
                        pw.println(filename[i]);
                        pw.flush();
                    }
                } catch (Exception e) {
                    pw.println("error");
                    pw.flush();
                }
            } else {
                pw.println("Command not found");
                pw.flush();
            }
            br.close();
            pw.close();
            s.close();
            in.close();
            out.close();
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        ServerSocket serv = null;
        ExecutorService es = Executors.newFixedThreadPool(10);
        try {
            serv = new ServerSocket(6789);
        } catch (Exception e) {
            System.exit(1);
        }
        while (true) {
            try {
                Socket s = serv.accept();
                FileServer fs = new FileServer(s);
                es.execute(fs);
            } catch (Exception e) {}
        }
    }
}
