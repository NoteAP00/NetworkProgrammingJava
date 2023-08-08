
import java.util.*;
public class Consumer extends Thread {
    Warehouse w;
    public Consumer (Warehouse w){
        this.w = w;
    }
    public void run(){
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int id = r.nextInt(100);
            System.out.println("Consumer: try to take product with id = " + id);
            w.put(id);
            System.out.println("Consumer: take product with id = " + id);
            try {
                Thread.sleep(r.nextInt(1000));
            }catch(Exception e){}
        }
    }
}
