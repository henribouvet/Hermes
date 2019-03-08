package fr.univnantes.hermes.tomp2p;

import net.tomp2p.p2p.Peer;
import fr.univnantes.hermes.api.DHT;
import fr.univnantes.hermes.api.DHTService;

import java.io.Serializable;

public class TomP2PService implements DHTService {
    public <K extends Serializable, V extends Serializable> DHT<K, V> createDHT() {
        Peer peer = null;
        //Peer peer = new PeerMaker(new Number160(rnd)).setPorts(port).buildAndListen();
        //return new TomP2PAdapter(peer);

        return null;
    }


}
