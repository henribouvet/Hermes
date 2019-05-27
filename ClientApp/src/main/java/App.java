import net.tomp2p.p2p.Peer;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World !");
        Peer peer;
        //FutureDHT<net.tomp2p.futures.BaseFuture> dht;


        WeldContainer weld = new Weld().initialize();
        //HermesFactory fac = new HermesFactory();


    }
}
