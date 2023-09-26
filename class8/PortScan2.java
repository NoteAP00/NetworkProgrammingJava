import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PortScan2 {
    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                System.out.println("Usage: java PortScan <hostname/IP>");
                System.exit(1);
            }

            String targetHost = args[0];
            int numberOfThreads = Runtime.getRuntime().availableProcessors(); // Number of CPU cores
            ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

            for (int i = 1; i <= 25565; i++) {
                executor.execute(new PortScanner(targetHost, i));
            }

            executor.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class PortScanner implements Runnable {
        private final String host;
        private final int port;

        public PortScanner(String host, int port) {
            this.host = host;
            this.port = port;
        }

        @Override
        public void run() {
            try {
                Socket socket = new Socket();
                InetAddress address = InetAddress.getByName(host);
                socket.setSoTimeout(2000);

                socket.connect(new InetSocketAddress(address, port));
                System.out.println("Port = " + port + " Open");
                socket.close();
            } catch (Exception e) {
            }
        }
    }
}
