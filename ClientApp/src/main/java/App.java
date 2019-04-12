import fr.univnantes.hermes.api.DHT;
import fr.univnantes.hermes.api.DHTService;
import fr.univnantes.hermes.api.api.Key20;
import fr.univnantes.hermes.kademlia.KademliaService;
import net.tomp2p.dht.FutureDHT;
import net.tomp2p.p2p.Peer;

import java.io.IOException;
import java.io.Serializable;

public class App {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World !");
        Peer peer;
        //FutureDHT<net.tomp2p.futures.BaseFuture> dht;
        DHTService service = new KademliaService();
        DHT kademlia = service.createDHT();
        Key20 key = new Key20();
        Serializable k1 = kademlia.store(key.get(),"Hey");
        Serializable k2 = kademlia.store(new Key20().get(),"Brother");
        Serializable v1 = kademlia.retrieve(k1);
        Serializable v2 = kademlia.retrieve(k2);
        System.out.println(v1);
        System.out.println(v2);
        service.shutDownServer();
    }
}
