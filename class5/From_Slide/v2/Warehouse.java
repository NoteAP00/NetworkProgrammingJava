public class Warehouse {
    volatile int productID;
    volatile boolean empty = true;

    public synchronized boolean put(int productID){
        if(!empty){ return false; }
        empty = false;
        this.productID = productID;
        return true;
    }

    public synchronized int take(){
        if (empty){ return -1; }
        int result = this.productID;
        empty = true;
        return result;
    }
    
}
