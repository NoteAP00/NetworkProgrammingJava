public class Friend {
    private String name;

    public Friend(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public synchronized void bow(Friend bower) {
        System.out.println(name + ": " + bower.getName() + " has bowed to me. ");
        bower.bowBack(this);
    }

    public synchronized void bowBack(Friend bower) {
        System.out.println(name + ": " + bower.getName() + " has bowed back to me. ");
    }

    public void run() {

    }

    public static void main(String[] args) {
        final Friend tom = new Friend("Tom");
        final Friend bob = new Friend("Bob");
        new Thread(new Runnable() {
            public void run() {
                tom.bow(bob);
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                bob.bow(tom);
            }
        }).start();
    }
}
