import java.io.*;

public class JavaTextCopy {
    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                throw new FileNotFoundException();
            }

            String Sdir = args[0];
            String Ddir = args[1];
            File Sfile = new File(Sdir);
            File Dfile = new File(Ddir);
            FileInputStream fin = new FileInputStream(Sfile);
            FileOutputStream fout = new FileOutputStream(Dfile);

            InputStreamReader ir = new InputStreamReader(fin);
            BufferedReader br = new BufferedReader(ir);
            String msg;
            PrintWriter pout = new PrintWriter(fout);
            
            while((msg = br.readLine()) != null){
                pout.println(msg);
            }
            
            fin.close();
            pout.flush();
            fout.close();
        } catch (FileNotFoundException e){
            System.out.println("Usage : java JavaBinaryCopy <source file> <destination file>");
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}