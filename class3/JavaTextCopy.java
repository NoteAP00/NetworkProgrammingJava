import java.io.*;

public class JavaTextCopy {
    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                throw new ArrayIndexOutOfBoundsException();
            }
            String msg;
            String Sdir = args[0];
            String Ddir = args[1];
            File Sfile = new File(Sdir);
            File Dfile = new File(Ddir);
            FileInputStream fin = new FileInputStream(Sfile);
            FileOutputStream fout = new FileOutputStream(Dfile);

           InputStreamReader ir = new InputStreamReader(fin);
           BufferedReader br = new BufferedReader(ir);

           String data = "";
           while((msg = br.readLine()) != null){

           }

        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Usage : java JavaBinaryCopy <source file> <destination file>");
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}