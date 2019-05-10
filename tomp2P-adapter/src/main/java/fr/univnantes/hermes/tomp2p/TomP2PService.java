package fr.univnantes.hermes.tomp2p;

import net.tomp2p.dht.PeerBuilderDHT;
import net.tomp2p.dht.PeerDHT;
import net.tomp2p.peers.Number160;
import net.tomp2p.p2p.PeerBuilder;
import fr.univnantes.hermes.api.DHT;
import fr.univnantes.hermes.api.DHTService;


import java.io.IOException;
import java.util.Random;

public class TomP2PService implements DHTService {


    public TomP2PService(){

    }

    public DHT createDHT() throws IOException {

        Random rnd = new Random( 43L );
        PeerDHT peer = new PeerBuilderDHT(new PeerBuilder(new Number160(rnd)).ports(1663).start()).start();
        return new TomP2PAdapter(peer);

    }

    @Override
    public void shutDownServer() {

    }
}
