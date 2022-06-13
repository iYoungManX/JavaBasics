package Network.UDP.Multiple;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws  Exception{
        DatagramSocket socket = new DatagramSocket(8888);

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
