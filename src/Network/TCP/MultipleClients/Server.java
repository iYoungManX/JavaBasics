package Network.TCP.MultipleClients;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public static void main(String[] args) {
        System.out.println("===========Server Starting=========");
        try {
            ServerSocket serverSocket = new ServerSocket(7777);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println(socket.getRemoteSocketAddress() + " is online right now ! ");

                new ServerReaderThread(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
