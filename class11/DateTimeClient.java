import java.net.*;;
public class DateTimeClient {
    public static void main(String[] args) {
        try {
            byte [] sendBuffer;
            byte [] recvBuffer = new byte[512];
            InetAddress address = InetAddress.getByName("127.0.0.1");
            DatagramSocket socket = new DatagramSocket();
            String message = "get time";
            sendBuffer = message.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, address, 9876);
            socket.send(sendPacket);
            DatagramPacket recvPacket = new DatagramPacket(recvBuffer, recvBuffer.length);
            socket.receive(recvPacket);
            String recvMessage = new String(recvPacket.getData(), 0 , recvPacket.getLength());
            System.out.println("Server Time --> " + recvMessage);
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
