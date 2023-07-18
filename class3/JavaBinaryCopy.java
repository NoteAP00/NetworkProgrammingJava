import java.io.*;

public class JavaBinaryCopy {
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

            int Sn ;
            byte[] Sb = new byte[16];
            String data = "";
            while((Sn = fin.read(Sb)) > 0){
                data += new String(Sb , 0 , Sn);
            }
            fin.close();
            byte[] b = data.getBytes();
            fout.write(b);
            fout.close();

        } catch (FileNotFoundException e){
            System.out.println("Usage : java JavaBinaryCopy <source file> <destination file>");
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}