package Internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpAddress {

    public static void main(String[] args) throws Exception {
        // 1. get local host information
        InetAddress ip1= InetAddress.getLocalHost();
        System.out.println(ip1.getHostName());
        System.out.println(ip1.getHostAddress());

        // 2. get google information
        InetAddress ip2= InetAddress.getByName("www.google.com");
        System.out.println(ip2.getHostName());
        System.out.println(ip2.getHostAddress());


        // 3. get google information by ip
        InetAddress ip3= InetAddress.getByName("142.250.80.68");
        System.out.println(ip3.getHostName());
        System.out.println(ip3.getHostAddress());


        // 4. ping test

        System.out.println(ip2.isReachable(5000));





    }
}
