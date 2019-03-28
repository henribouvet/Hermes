package fr.univnantes.hermes.tomp2p;

import io.netty.util.internal.ThreadLocalRandom;
import net.tomp2p.dht.FutureDHT;
import net.tomp2p.dht.PeerBuilderDHT;
import net.tomp2p.dht.PeerDHT;
import net.tomp2p.peers.Number160;
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

    public DHT createDHT() throws IOException {

        Random rnd = new Random( 43L );
        //PeerBuilder peertemp = );
        PeerDHT peer = new PeerBuilderDHT(new PeerBuilder(new Number160(rnd)).ports(1663).start()).start();
        return new TomP2PAdapter(peer);

        //return dht;
    }

    private String nextOwnerId() {
        return "owner" + this.ownerId++;
    }


}
