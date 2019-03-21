package fr.univnantes.hermes.tomp2p;

import io.netty.util.internal.ThreadLocalRandom;
import net.tomp2p.dht.FutureDHT;
import net.tomp2p.peers.Number160;
import net.tomp2p.dht.;
import net.tomp2p.p2p.Peer;
import net.tomp2p.p2p.PeerBuilder;
import fr.univnantes.hermes.api.DHT;
import fr.univnantes.hermes.api.DHTService;
import fr.univnantes.hermes.api.base.HermesDHTService;
import org.mapdb.Atomic;

import java.io.IOException;
import java.io.Serializable;
import java.util.Random;

public class TomP2PService implements DHTService {

    private int ownerId = 0;

    public TomP2PService(){

    }

    public  DHT createDHT() throws IOException {

        String ownerId = this.nextOwnerId();
        Random rnd = new Random( 43L );
        PeerBuilder peertemp = new PeerBuilder(new Number160(rnd)).ports(1663);
        Peer peer = peertemp.start();

        DHT<String, String> dht = (new HermesDHTService()).createDHT(ownerId);

        return dht;
    }

    private String nextOwnerId() {
        return "owner" + this.ownerId++;
    }


}
