package fr.univnantes.hermes.kademlia;

import fr.univnantes.hermes.api.DHT;
import kademlia.JKademliaNode;
import kademlia.dht.JKademliaStorageEntry;
import kademlia.dht.KademliaDHT;
import kademlia.dht.KademliaStorageEntry;
import kademlia.node.KademliaId;
import kademlia.simulations.DHTContentImpl;

import javax.annotation.ParametersAreNonnullByDefault;
import java.io.IOException;
import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.Future;

public class KademliaAdapter implements DHT<Serializable, Serializable> {
    private JKademliaNode kad = new JKademliaNode("owner0",new KademliaId("dataDataDataDataData"),15);

    public KademliaAdapter() throws IOException {
    }


    /*public Future<Object> retrieve(Object key) {
        return null;
    }

    public boolean remove(Object data) {
        return false;
    }*/

    @ParametersAreNonnullByDefault
    public boolean store(Serializable key, Serializable value) throws IOException {
        JKademliaStorageEntry entry = new JKademliaStorageEntry(new DHTContentImpl());
        return 0 < this.kad.put(entry);
    }

    @ParametersAreNonnullByDefault
    public Future<Serializable> retrieve(Serializable key) throws IOException {
        return null;//this.kad.retrieve(key);
    }

    @ParametersAreNonnullByDefault
    public void remove(Serializable key) {
    }


    public String getOwnerId() {
        return this.kad.getOwnerId();
    }
}
