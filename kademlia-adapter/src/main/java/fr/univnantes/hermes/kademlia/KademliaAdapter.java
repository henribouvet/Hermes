package fr.univnantes.hermes.kademlia;

import fr.univnantes.hermes.api.DHT;
import kademlia.JKademliaNode;
import kademlia.dht.*;
import kademlia.exceptions.ContentNotFoundException;
import kademlia.node.KademliaId;
import kademlia.simulations.DHTContentImpl;

import javax.annotation.ParametersAreNonnullByDefault;
import java.io.IOException;
import java.io.Serializable;

public class KademliaAdapter implements DHT<Serializable, Serializable> {
    private JKademliaNode kad = new JKademliaNode("owner0",new KademliaId(),15);

    public KademliaAdapter() throws IOException {
    }


    /*public Future<Object> retrieve(Object key) {
        return null;
    }

    public boolean remove(Object data) {
        return false;
    }*/

    @ParametersAreNonnullByDefault
    public Serializable store(Serializable key, Serializable value) throws IOException {
        KadContent content = new DHTContentImpl(kad.getOwnerId(), value.toString());
        JKademliaStorageEntry entry = new JKademliaStorageEntry(content, new StorageEntryMetadata(content));
        this.kad.put(entry);
        // To get the usable KademliaId
        return entry.getContentMetadata().getKey();
    }

    @ParametersAreNonnullByDefault
    public Serializable retrieve(Serializable key) throws IOException {
        GetParameter gp = new GetParameter((KademliaId) key, DHTContentImpl.TYPE);
        gp.setOwnerId(getOwnerId());
        try {
             String content = new DHTContentImpl().fromSerializedForm(kad.get(gp).getContent()).toString();

             // Data starts at char 20
             int bracket = 20;
             // To get the "data" substring
             for (int i = 20; i < content.length(); ++i) {
                 if (content.charAt(i) == '{') {
                     bracket = i;
                     break;
                 }
             }
             return content.substring(21, bracket);

        } catch (ContentNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @ParametersAreNonnullByDefault
    public void remove(Serializable key) {
    }


    public String getOwnerId() {
        return this.kad.getOwnerId();
    }

}
