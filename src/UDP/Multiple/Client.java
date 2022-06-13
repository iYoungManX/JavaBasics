package UDP.Multiple;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

// multiple send
public class Client {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();

        Scanner sc= new Scanner(System.in);
        while (true){
            System.out.println("UDP : Please enter the message");
            String msg= sc.nextLine();

            if("exit".equals(msg)){
                System.out.println("Exiting ....");
                socket.close();
                break;
            }
            byte[] buffer =msg.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer,buffer.length, InetAddress.getLocalHost(),8888);
            socket.send(packet);
        }



    }
}
