import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.Date;
 
public class Assignment3{

   public static void main(String[] args) {
      long[] responseTimes=new long[5];
      try {
         String hostAddress = "www.google.com";
         int port = 80;
         long timeToRespond = 0;

         InetAddress inetAddress = InetAddress.getByName(hostAddress);
         InetSocketAddress socketAddress = new InetSocketAddress(inetAddress, port);

         for(int i=0;i<5;i++) {
            SocketChannel sc = SocketChannel.open();
            sc.configureBlocking(true);

            Date start = new Date();
            if (sc.connect(socketAddress)) {
               Date stop = new Date();
               timeToRespond = (stop.getTime() - start.getTime());
            }
            sc.close();
            responseTimes[i]=timeToRespond;
            System.out.println("Response time: " + timeToRespond + " ms");
         }
         Arrays.sort(responseTimes);
         System.out.println("Median of response times:"+responseTimes[2]);

      }
      catch (IOException ex) {
         System.out.println(ex.getMessage());
      }

   }
}