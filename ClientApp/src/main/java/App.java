import fr.univnantes.hermes.api.DHT;
import fr.univnantes.hermes.kademlia.KademliaAdapter;
import fr.univnantes.hermes.kademlia.KademliaService;
import net.tomp2p.dht.FutureDHT;
import net.tomp2p.p2p.Peer;

import java.io.IOException;
import java.util.Random;

public class App {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World !");
        Peer peer;
        FutureDHT dht;
        DHT kademlia = new KademliaService().createDHT();
        kademlia.store(3,"Hello");
        kademlia.store(4,"World");

        return;
    }
}
