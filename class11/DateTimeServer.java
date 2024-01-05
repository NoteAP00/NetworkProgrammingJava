import java.net.*;
import java.util.*;

public class DateTimeServer implements Runnable {
    DatagramSocket socket = null;

    public DateTimeServer(DatagramSocket socket) {
        this.socket = socket;
    }

    public static String thisTime() {
        return (new Date()).toString();
    }

    public void run() {
        try {
            byte[] recvBuffer = new byte[8000];
            DatagramPacket recvPacket = new DatagramPacket(recvBuffer, recvBuffer.length);
            socket.receive(recvPacket);
            System.out.println("Client Connected . .");
            String date = (new Date()).toString();
            DatagramPacket sendPacket = new DatagramPacket(thisTime().getBytes(),
                                            thisTime().getBytes().length,
                                            recvPacket.getAddress(),
                                            recvPacket.getPort());
            socket.send(sendPacket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("Current Time = " + DateTimeServer.thisTime());
            DatagramSocket socket = new DatagramSocket(9876);
            while (true) {
                DateTimeServer ds = new DateTimeServer(socket);
                Thread t = new Thread(ds);
                t.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
