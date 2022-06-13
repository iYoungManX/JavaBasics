package TCP.MultipleClients;

import java.io.BufferedReader;

import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.Socket;

public class ServerReaderThread extends Thread{
    private Socket socket;
    public ServerReaderThread(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {

        try {
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String msg;
            while ((msg=br.readLine())!=null){
                System.out.println(socket.getRemoteSocketAddress()+" Input: "+msg);
            }

        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println(socket.getRemoteSocketAddress()+" is Offline now !");
        }

    }
}
