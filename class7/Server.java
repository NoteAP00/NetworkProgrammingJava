import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.HashMap;

public class Server implements Runnable {
    Socket clientSocket = null;
    static HashMap<String, String> data = new HashMap<String, String>();

    public Server(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        String command[] = new String[3];
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            for (int i = 0; i < command.length; i++) {
                command[i] = reader.readLine();
            }
        } catch (IOException e) {}
        String result = "";
        if (command[0].equals("add") && command[1] != null && !(command[2].equals("0"))) {
            data.put(command[1], command[2]);
            result = "Result = OK";
        } else if (command[0].equals("search") && command[1] != null && command[2].equals("0")) {
            result = "Result = " + data.getOrDefault(command[1], "N/A");
        } else {
            result = "Command not found";
        }
        try {
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
            writer.println(result);
            writer.flush();
            writer.close();
            clientSocket.close();
        } catch (IOException e) {}
    }

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        ExecutorService executorService = Executors.newFixedThreadPool(15);
        int port = 23410;
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                Server server = new Server(clientSocket);
                executorService.execute(server);
            }
        } catch (IOException e) {}
    }
}
