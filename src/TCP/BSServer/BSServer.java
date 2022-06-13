package TCP.BSServer;



import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BSServer {

    private static ExecutorService pool = new ThreadPoolExecutor(3,5,6, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(2),new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args){
        try {
            ServerSocket ss = new ServerSocket(8080);
            while (true){
                Socket socket = ss.accept();
                pool.execute(new ServerReaderRunnable(socket));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}


class ServerReaderRunnable implements Runnable{
    private Socket socket;
    public ServerReaderRunnable(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {
        try {
            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.println("HTTP/1.1 200 OK");
            ps.println("Content-Type:text/html;charset=UTF-8");
            ps.println();
            ps.println("<h1> 我爱你 </h1>");
            ps.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}