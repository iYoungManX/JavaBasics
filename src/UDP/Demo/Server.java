package UDP.Demo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws  Exception{
        DatagramSocket socket = new DatagramSocket(8888);

        byte[] buffer =new byte[1024*64];
        DatagramPacket packet= new DatagramPacket(buffer,buffer.length);

        socket.receive(packet);
        int length = packet.getLength();
        String rs= new String(buffer,0,length);
        System.out.println("Get the message: "+rs);

        // get the sender ip
        String ip= packet.getSocketAddress().toString();
        System.out.println("Sender Ip: "+ip);
        // get the sender port
        int port= packet.getPort();
        System.out.println("Sender Port "+port);

        socket.close();
    }
}
