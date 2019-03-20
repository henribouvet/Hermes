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
import java.util.Iterator;

public class KademliaService implements DHTService {
    private int ownerId = 0;

    public KademliaService() {
    }

    public DHT createDHT() throws IOException {
        String ownerId = this.nextOwnerId();
        DHT<String, ArrayList<JKademliaStorageEntry>> dht = (new HermesDHTService()).createDHT(ownerId);
        KademliaDHT kademliaDHT = new kademlia.dht.DHT(ownerId, new DefaultConfiguration());
        Iterator var4 = kademliaDHT.getStorageEntries().iterator();

        while(var4.hasNext()) {
            KademliaStorageEntryMetadata entryMetadata = (KademliaStorageEntryMetadata)var4.next();
            ArrayList<JKademliaStorageEntry> list = (ArrayList)Arrays.asList(kademliaDHT.get(entryMetadata));
            dht.store(ownerId, list);
        }

        return dht;
    }

    private String nextOwnerId() {
        return "owner" + this.ownerId++;
    }
}
