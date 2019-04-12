package fr.univnantes.hermes.kademlia;


import fr.univnantes.hermes.api.DHT;
import fr.univnantes.hermes.api.DHTService;
import fr.univnantes.hermes.api.base.HermesDHTService;
import kademlia.DefaultConfiguration;
import kademlia.dht.JKademliaStorageEntry;
import kademlia.dht.KademliaDHT;
import kademlia.dht.KademliaStorageEntryMetadata;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class KademliaService implements DHTService {
    private int ownerId = 0;
    KademliaAdapter adapter;

    public KademliaService() {
    }

    public DHT createDHT() throws IOException {
        adapter = new KademliaAdapter();
        return adapter;
    }

    private String nextOwnerId() {
        return "owner" + this.ownerId++;
    }

    @Override
    public void shutDownServer() {
        adapter.shutDownServer();
    }
}
