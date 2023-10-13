import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class readMath {
   
    public static void main(String[] args) {
        if(args.length < 2) {
            System.err.println("Usage: java readMath <file> <column>");
            System.exit(1);
        }
        try {
            File file = new File(args[0]);
            Scanner scanner = new Scanner(file);

            // อ่านขนาดของ array 2 มิติ
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();

            // สร้าง array 2 มิติ
            int[][] data = new int[rows][columns];

            // อ่านข้อมูลและเก็บใน array 2 มิติ
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    data[i][j] = scanner.nextInt();
                }
            }

            scanner.close();
            int sum = 0;
            
                for (int j = 0; j < data[Integer.parseInt(args[1])].length; j++) {
                    System.out.print(data[Integer.parseInt(args[1])][j] + " ");
                    sum += data[Integer.parseInt(args[1])][j];
                }
                System.out.println();
            
                System.out.println("Sum of row " + args[1] + " = " + sum);
            // // แสดงข้อมูลใน array 2 มิติ
            // for (int i = 0; i < rows; i++) {
            //     for (int j = 0; j < columns; j++) {
            //         System.out.print(data[i][j] + " ");
            //     }
            //     System.out.println();
            // }
                sum =0;
            // for (int i = 4; i >= 0; i--) {
            //     System.out.print(data[5-i-1][i] + " ");
            //     sum += data[5-i-1][i];
            // }

            for (int i = 0; i < data.length; i++) {
                System.out.println(data[i][1] + " ");
                sum += data[i][1];
            }
            System.out.println();
            System.out.println("Sum of Tayangmumb = " + sum);
            double size = file.length()/1000.0;
            System.out.println("fileSize = " + size + " KB");
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFound");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
