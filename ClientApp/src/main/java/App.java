import fr.univnantes.hermes.api.DHT;
import fr.univnantes.hermes.kademlia.KademliaAdapter;
import net.tomp2p.dht.FutureDHT;
import net.tomp2p.p2p.Peer;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World !");
        Peer peer;
        FutureDHT dht;
        KademliaAdapter kademliaAdapter = new KademliaAdapter();
        kademliaAdapter.store("Hello");
        return;
    }
}
