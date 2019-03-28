import fr.univnantes.hermes.api.DHT;
import fr.univnantes.hermes.kademlia.KademliaService;
import net.tomp2p.dht.FutureDHT;
import net.tomp2p.p2p.Peer;

import java.io.IOException;
import java.io.Serializable;

public class App {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World !");
        Peer peer;
        FutureDHT<net.tomp2p.futures.BaseFuture> dht;
        DHT kademlia = new KademliaService().createDHT();
        Serializable k1 = kademlia.store(3,"Hey");
        Serializable k2 = kademlia.store(4,"Brother");
        Serializable v1 = kademlia.retrieve(k1);
        Serializable v2 = kademlia.retrieve(k2);

        return;
    }
}
