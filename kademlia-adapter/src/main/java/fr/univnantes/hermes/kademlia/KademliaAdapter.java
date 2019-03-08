package fr.univnantes.hermes.kademlia;

import fr.univnantes.hermes.api.DHT;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.Future;


// The Kademlia implementation has been downloaded locally, and store as a submodule in kademlia-adapter

public class KademliaAdapter implements DHT<Serializable, Serializable>{

    private DHT kadDHT;
    private KademliaService kadService;

    public KademliaAdapter()  throws IOException {

        kadService = new KademliaService();

        kadDHT = kadService.createDHT();
    }



    public boolean store(Object data) throws IOException {
        return kadDHT.store(kadDHT.getOwnerId(), data.toString());
    }

    public Future<Object> retrieve(Object key) {
        return null;
    }

    public boolean remove(Object data) {
        return false;
    }

    public boolean store(Serializable key, Serializable value) throws IOException {

        return false;
    }

    public Future<Serializable> retrieve(Serializable key) throws IOException {
        return null;
    }

    public void remove(Serializable key) throws IOException {

    }

    @Override
    public String getOwnerId() {
        return kadDHT.getOwnerId();
    }
}
