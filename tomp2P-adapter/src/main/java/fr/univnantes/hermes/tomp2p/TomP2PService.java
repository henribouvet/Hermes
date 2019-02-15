package fr.univnantes.hermes.tomp2p;

import net.tomp2p.p2p.Peer;
import net.tomp2p.peers.Number160;
import org.atlanmod.hermes.DHT;
import org.atlanmod.hermes.DHTService;

import java.io.Serializable;

public class TomP2PService implements DHTService {
    public <K extends Serializable, V extends Serializable> DHT<K, V> createDHT() {
        Peer peer = null;
        //Peer peer = new PeerMaker(new Number160(rnd)).setPorts(port).buildAndListen();
        //return new TomP2PAdapter(peer);

        return null;
    }


}
