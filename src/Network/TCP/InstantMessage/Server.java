package Network.TCP.InstantMessage;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static List<Socket> allOnlineSockets = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("===========Server Starting=========");
        try {
            ServerSocket serverSocket = new ServerSocket(7777);
            while(true){
                Socket socket= serverSocket.accept();
                System.out.println(socket.getRemoteSocketAddress()+" is online right now ! ");
                allOnlineSockets.add(socket);
                new ServerReaderThread(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class ServerReaderThread extends Thread{
    private Socket socket;
    public ServerReaderThread(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {

        try {
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line=br.readLine())!=null){
                System.out.println(socket.getRemoteSocketAddress()+" Input: "+line);
                sendMsgToAll(line);
            }

        } catch (Exception e) {
            Server.allOnlineSockets.remove(socket);
        }

    }

    private void sendMsgToAll(String msg) throws Exception{
        for (Socket socket : Server.allOnlineSockets) {
            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.println(msg);
            ps.flush();
        }

    }
}

