public class Fork {
    volatile boolean taked = false;// เก็บสถานะว่าส้อมนี้ถูกใช้งานอยู่หรือไม่
    String holderName = " "; // เก็บชื่อ Philosopher ที่ใช้งานส้อมนี้อยู่
    
    public String getHolderName() {
        return holderName;
    }

    // Philosopher เรียกใช้เมื่อต้องการใช้ส้อม ถ้าส้อมไม่ว่างให้คืนค่า false 
    // ถ้าส้อมว่างจะต้องตั้งค่า taked และใส่ชื่อคนที่จะใช้ส้อมและคืนค่า true ว่าสามารถหยิบส้อมมาใช้งานได้

    public synchronized boolean take(String holderName) {
        if(taked){
            return false;
        }else{
            this.taked = true;
            this.holderName = holderName;
            return true;
        }        
    }

    //Philosopher จะเรียกใช้เมื่อต้องการเลิกใช้งานส้อมนี้
    public synchronized void putDown() {
        this.taked = false;
        this.holderName = " ";
    }
}