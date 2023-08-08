
import java.util.*;
public class Producer extends Thread {
    Warehouse w;
    public Producer (Warehouse w){
        this.w = w;
    }
    public void run(){
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int id = r.nextInt(100);
            System.out.println("Producer: try to put product with id = " + id);
            while(!w.put(id));
            System.out.println("Producer: put product with id = " + id);
            try {
                Thread.sleep(r.nextInt(1000));
            }catch(Exception e){}
        }
    }
}
