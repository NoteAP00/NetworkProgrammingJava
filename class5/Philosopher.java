import java.util.*;

public class Philosopher extends Thread {
    Fork left, right; 
    String name; 
    String status = "---"; 
    int numEat = 0;
    boolean done = false;
    Random r = new Random();

    public Philosopher(String name, Fork left, Fork right) { 
        this.left = left;
        this.right = right;
        this.name = name;
    }

    public String getStatus() {
        return status;
    } 

    public int getNumEat() {
        return numEat;
    } 

    public void done() {
        done = true;
    } 

    public void think() { 
        status = "THK";
        try {
            Thread.sleep(r.nextInt(150) + 150);
        } catch (Exception e) {
        }
    }

    public void eat() { 
        status = "EAT";
        try {
            Thread.sleep(r.nextInt(150) + 150);
        } catch (Exception e) {
        }
    }

    
    public void run() {
        while (!done) {
            think();
            boolean isEven = Integer.parseInt(name.substring(1)) % 2 == 0 ? true : false;
            if(isEven){
                if(left.getHolderName() == "  "){
                    left.take(name);
                    if(right.getHolderName() == "  "){
                        right.take(name);
                        eat();
                        numEat++;
                        left.putDown();
                        right.putDown();
                    } else {
                        left.putDown();
                    }
                }            
            } else {
                if(right.getHolderName() == "  "){
                    right.take(name);
                    if(left.getHolderName() == "  "){
                        left.take(name);
                        eat();
                        numEat++;
                        left.putDown();
                        right.putDown();
                    } else {
                        right.putDown();
                    }
                }    
            }
        }
    }
}