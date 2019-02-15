package fr.univnantes.hermes.kademlia;

import kademlia.JKademliaNode;
import kademlia.KademliaNode;
import org.atlanmod.hermes.DHT;
import kademlia.node.KademliaId;
import kademlia.simulations.DHTContentImpl;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.Future;


// The Kademlia implementation has been downloaded locally, and put as a submodule in kademlia-adapter

public class KademliaAdapter implements DHT<Serializable, Serializable>{

    KademliaNode kad;
    int ownerId = 0;

    public KademliaAdapter()  throws IOException {
        kad = new JKademliaNode(nextOwnerId(), new KademliaId(), 10);
    }

    private String nextOwnerId() {
        return "owner" + ownerId++;
    }


    public boolean store(Object data) throws IOException {
        return 0 < kad.put(new DHTContentImpl(kad.getOwnerId(), data.toString()));
    }

    public Future<Object> retrieve(Object key) {
        return null;
    }

    public boolean remove(Object data) {
        return false;
    }

    public void store(Serializable key, Serializable value) throws IOException {

    }

    public Future<Serializable> retrieve(Serializable key) throws IOException {
        return null;
    }

    public void remove(Serializable key) throws IOException {

    }
}
