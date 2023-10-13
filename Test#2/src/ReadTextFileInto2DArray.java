import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadTextFileInto2DArray {
    public static void main(String[] args) {
        // if(args.length == 0){
        //     System.err.println("กรุณาระบุชื่อไฟล์ที่ต้องการอ่านข้อมูล");
        //     System.exit(1);
        // }
        try {
            File file = new File("example.txt");
            Scanner scanner = new Scanner(file);
            System.out.println(file.length());
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

            // แสดงข้อมูลใน array 2 มิติ
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print(data[i][j] + " ");
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}