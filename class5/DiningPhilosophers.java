public class DiningPhilosophers {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Fork[] fork = new Fork[n]; // สร้าง Array สำหรับ Object ของส้อม n อัน
        Philosopher[] philosopher = new Philosopher[n]; // สร้าง Array Object ของ Philosopher n คน
        // ใส่ code ตรงนี้เพื่อสร้างObject ของส้อม และ Philosopher ให้ชื่อของ
        // Philosopher คือ P0, P1,... ตามลำดับ

        // TODO : code คือไรน้าา

        // ส่วนแสดงผลทุกๆ 100 ms เป็นจ านวน100 ครั้งก่อนให้จบโปรแกรม
        String info;
        for (int i = 0; i < 100; i++) {
            info = "|";
            for (int j = 0; j < n; j++) {
                info += (philosopher[j].getStatus() + "|");
            }
            info += "\t\t|";
            for (int j = 0; j < n; j++) {
                info += (fork[j].getHolderName() + "|");
            }
            System.out.println(info);
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
        }

        for (int i = 0; i < n; i++) {
            philosopher[i].done();
            System.out.println("P" + i + ": eat " + philosopher[i].getNumEat() + " times");
        }
    }
}
