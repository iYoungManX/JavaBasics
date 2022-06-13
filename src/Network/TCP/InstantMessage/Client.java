package Network.TCP.InstantMessage;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        System.out.println("===========Client Starting=========");
        try {
            Socket socket = new Socket("127.0.0.1",7777);
            new ClientReaderThread(socket).start();

            OutputStream os = socket.getOutputStream();

            PrintStream ps = new PrintStream(os);

            Scanner sc = new Scanner(System.in);
            while(true){
                System.out.println("Please enter your message:");
                String msg =sc.nextLine();
                ps.println(msg);
                ps.flush();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


class ClientReaderThread extends Thread{
    private Socket socket;

    public ClientReaderThread(Socket socket){this.socket=socket;}

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String msg;
            while ((msg=br.readLine())!=null){
                System.out.println("Get the message:  "+msg);
            }

        } catch (Exception e) {

            System.out.println("Server has kicked you out");
        }
    }
}
