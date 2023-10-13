import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
public class arr2dMake {
    public static void main(String[] args) {
        Random Random = new Random();
        int rows = Random.nextInt(100);
        int columns = Random.nextInt(100);
        try {
            String fileName = args[0];
            File file = new File(fileName);
            PrintWriter pw = new PrintWriter(file);
            pw.println(rows); //แถว
            pw.flush();
            pw.println(columns); //หลัก
            pw.flush();
            int [][] data = new int[rows][columns];
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    data[i][j] = Random.nextInt(100);
                    pw.print(data[i][j] + " ");
                    pw.flush();
                }
                pw.println();
                pw.flush();
            }
            pw.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
