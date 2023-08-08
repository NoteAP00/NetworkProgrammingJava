
import java.util.*;
public class Consumer extends Thread {
    Warehouse w;
    public Consumer (Warehouse w){
        this.w = w;
    }
    public void run(){
        int id;
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println("Consumer: try to take product");
            while((id = w.take()) == -1);
            System.out.println("Consumer: take product with id = " + id);
            try {
                Thread.sleep(r.nextInt(1000));
            }catch(Exception e){}
        }
    }
}
