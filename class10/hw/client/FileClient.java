import java.io.*;
import java.net.*;

public class FileClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1", 6789);
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            PrintWriter pw = new PrintWriter(out);
            if (args.length == 2) {
                if (args[0].equals("upload")) {
                    try {
                        File f = new File(args[1]);
                        if (!f.isFile()) {
                            System.out.println(args[1] + " not found");
                            System.exit(1);
                        }
                        if (f.exists()) {
                            pw.println("upload");
                            pw.flush();
                            pw.println(args[1]);
                            pw.flush();
                            FileInputStream fin = new FileInputStream(f);
                            byte[] b = new byte[65536];
                            int size;
                            while ((size = fin.read(b)) > 0) {
                                out.write(b, 0, size);
                            }
                            out.flush();
                        } else {
                            System.out.println(args[1] + " not found");
                            System.exit(1);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (args[0].equals("download")) {
                    pw.println("download");
                    pw.flush();
                    pw.println(args[1]);
                    pw.flush();
                    String response = br.readLine();
                    if (response.equals("OK")) {
                        File f = new File(args[1]);
                        FileOutputStream fout = new FileOutputStream(f);
                        byte[] b = new byte[65536];
                        int size;
                        while ((size = in.read(b)) > 0) {
                            fout.write(b, 0, size);
                        }
                    } else {
                        System.out.println(response);
                    }

                } else {
                    if ("upload".equals(args[0]) || "download".equals(args[0])) {
                        System.out.println("error");
                    } else {
                        System.out.println("command not found");
                    }
                }
            } else if (args.length == 1 && args[0].equals("list")) {
                pw.println("list");
                pw.flush();
                String filename;
                while ((filename = br.readLine()) != null) {
                    System.out.println(filename);
                }
            } else {
                System.out.println("command not found");
            }

            pw.close();
            br.close();
            s.close();
            in.close();
            out.close();
        } catch (Exception e) {
        }
    }
}