public class Warehouse {
    volatile int productID;
    volatile boolean empty = true;

    public synchronized boolean put(int productID){
        if(!empty){ 
            try {
                wait();
            }catch(Exception e) {}
        }
        this.productID = productID;
        empty = false;
        notify();
        return true;
    }

    public synchronized int take(){
        if (empty){ 
            try{
                wait();
            }catch(Exception e){}
         }
        int result = this.productID;
        empty = true;
        notify();
        return result;
    }
    
}
