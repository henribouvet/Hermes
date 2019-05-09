import fr.univnantes.hermes.api.DHT;
import fr.univnantes.hermes.api.DHTService;
import fr.univnantes.hermes.api.HermesFactory;
import fr.univnantes.hermes.api.api.Key20;
import fr.univnantes.hermes.kademlia.KademliaService;
import kademlia.node.KademliaId;
import net.tomp2p.dht.FutureDHT;
import net.tomp2p.p2p.Peer;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import java.io.IOException;
import java.io.Serializable;

public class App {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World !");
        Peer peer;
        //FutureDHT<net.tomp2p.futures.BaseFuture> dht;


        WeldContainer weld = new Weld().initialize();
        HermesFactory fac = new HermesFactory();


    }
}
