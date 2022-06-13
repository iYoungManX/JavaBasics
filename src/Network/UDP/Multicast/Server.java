package Network.UDP.Multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Server {
    public static void main(String[] args) throws  Exception{
        MulticastSocket socket = new MulticastSocket(9999);

        socket.joinGroup(InetAddress.getByName("224.0.1.1"));

        byte[] buffer =new byte[1024*64];
        DatagramPacket packet= new DatagramPacket(buffer,buffer.length);

        while(true){
            socket.receive(packet);
            int length = packet.getLength();
            String rs= new String(buffer,0,length);
            System.out.println("Get the message from " +packet.getSocketAddress()+" Port:"+packet.getPort()+"'s message: "+rs);

        }
    }
}
