public class ProducerConsumer {
    public static void main(String[] args) {
        Warehouse w = new Warehouse();
        Producer p = new Producer(w);
        Consumer c = new Consumer(w);
        p.start(); c.start();
    }
}
