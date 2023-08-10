public class Fork {
    volatile boolean taked = false;
    String holderName = "  ";
    
    public String getHolderName() {
        return holderName;
    }

    public synchronized boolean take(String holderName) {
        if(taked){
            try {
                wait();
                return false;
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
            this.taked = true;
            this.holderName = holderName;
            return true;
    }
    public synchronized void putDown() {
        this.taked = false;
        this.holderName = "  ";
        notify();
    }
}