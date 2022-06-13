package Network.TCP.TCPThreadPool;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class server {

    private static ExecutorService pool = new ThreadPoolExecutor(3,5,6, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(2),new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        System.out.println("===========Server Starting=========");
        try {
            ServerSocket serverSocket = new ServerSocket(7777);
            while(true){
                Socket socket= serverSocket.accept();
                System.out.println(socket.getRemoteSocketAddress()+" is online right now ! ");
                Runnable target = new ServerReaderRunnable(socket);
                pool.execute(target);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
