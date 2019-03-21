package fr.univnantes.hermes.kademlia;

import fr.univnantes.hermes.api.DHT;
import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.Future;

public class KademliaAdapter implements DHT<Serializable, Serializable> {
    private DHT kadDHT;
    private KademliaService kadService = new KademliaService();

    public KademliaAdapter() throws IOException {
        this.kadDHT = this.kadService.createDHT();
    }

    public boolean store(Serializable data) throws IOException {
        return this.kadDHT.store(this.kadDHT.getOwnerId(), data.toString());
    }

    /*public Future<Object> retrieve(Object key) {
        return null;
    }

    public boolean remove(Object data) {
        return false;
    }*/

    public boolean store(Serializable key, Serializable value) throws IOException {
        return this.kadDHT.store(key,value);
    }

    public Future<Serializable> retrieve(Serializable key) throws IOException {
        return this.kadDHT.retrieve(key);
    }

    public void remove(Serializable key) throws IOException {
    }

    public String getOwnerId() {
        return this.kadDHT.getOwnerId();
    }
}
