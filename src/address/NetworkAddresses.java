package address;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class NetworkAddresses {

    public static void main(String[] args) throws UnknownHostException {

        // josh and will are on campus so they see 10.x.x.x for a private IP
        // 10.16.80.95
        InetAddress[] ip = InetAddress.getAllByName("www.greenriver.edu");

        System.out.println(Arrays.toString(ip));

        for(InetAddress addr : ip){
            System.out.println(addr);
        }
    }
}
