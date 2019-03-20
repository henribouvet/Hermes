package fr.univnantes.hermes.api.base;

import fr.univnantes.hermes.api.DHT;
import fr.univnantes.hermes.api.DHTService;
import java.io.IOException;
import java.io.Serializable;

public class HermesDHTService implements DHTService {
    public HermesDHTService() {
    }

    public <K extends Serializable, V extends Serializable> DHT<K, V> createDHT() throws IOException {
        return this.createDHT((String)null);
    }

    public <K extends Serializable, V extends Serializable> DHT<K, V> createDHT(String ownerId) throws IOException {
        return new HermesDHT(ownerId);
    }
}
