//improve our code use ThreadPool
package Network.TCP.TCPThreadPool;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",7777);
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
