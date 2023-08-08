public class Warehouse {
    volatile int productID;
    volatile boolean empty = true;

    public synchronized void put(int productID){
        while(!empty){}
        empty = false;
        this.productID = productID;
    }

    public synchronized int take(){
        while (empty){}
        int result = this.productID;
        empty = true;
        return result;
    }
    
}
