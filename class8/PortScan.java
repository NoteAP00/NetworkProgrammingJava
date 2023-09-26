import java.net.*;

class PortScan {
    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                System.out.println("Usage: java PortScan <hostname/IP>");
                System.exit(1);
            }
            for (int i = 21; i <= 8081; i++) {
                try {
                    // Socket socket = new Socket(args[0],i);
                    Socket socket = new Socket();
                    InetAddress ad = InetAddress.getByName(args[0]);
                    socket.setSoTimeout(1000);
                    socket.connect(new InetSocketAddress(ad, i));
                    System.out.println("Port = " + i + " Open");
                    socket.close();
                } catch (Exception e) {
                }
            }
        } catch (Exception e) {
            // TODO: handle exception

        }
    }
}