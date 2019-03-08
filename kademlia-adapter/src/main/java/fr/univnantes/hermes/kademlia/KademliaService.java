package fr.univnantes.hermes.kademlia;

import Kademlia.src.kademlia.DefaultConfiguration;
import Kademlia.src.kademlia.dht.JKademliaStorageEntry;
import Kademlia.src.kademlia.dht.KademliaDHT;
import Kademlia.src.kademlia.dht.KademliaStorageEntryMetadata;
import fr.univnantes.hermes.api.DHT;
import fr.univnantes.hermes.api.DHTService;
import fr.univnantes.hermes.api.base.HermesDHT;
import fr.univnantes.hermes.api.base.HermesDHTService;
import fr.univnantes.hermes.api.base.NullDHT;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class KademliaService implements DHTService {

    private int ownerId = 0;


    @Override
    public <K extends Serializable, V extends Serializable> DHT<K, V> createDHT() throws IOException {
        String ownerId = nextOwnerId();

        DHT<String, ArrayList<JKademliaStorageEntry>> dht = (new HermesDHTService()).createDHT(ownerId);

        KademliaDHT kademliaDHT = new Kademlia.src.kademlia.dht.DHT(ownerId, new DefaultConfiguration());
        for (KademliaStorageEntryMetadata entryMetadata : kademliaDHT.getStorageEntries()) {
            ArrayList<JKademliaStorageEntry> list = (ArrayList<JKademliaStorageEntry>) Arrays.asList(kademliaDHT.get(entryMetadata));
            dht.store(ownerId, list);
        }

        return (DHT<K, V>) dht;
    }




    private String nextOwnerId() {
        return "owner" + ownerId++;
    }
}
