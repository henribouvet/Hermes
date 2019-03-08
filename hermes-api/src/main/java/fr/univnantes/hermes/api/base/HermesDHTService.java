package fr.univnantes.hermes.api.base;

import fr.univnantes.hermes.api.DHT;
import fr.univnantes.hermes.api.DHTService;

import java.io.IOException;
import java.io.Serializable;

public class HermesDHTService implements DHTService {
    public <K extends Serializable, V extends Serializable> DHT<K, V> createDHT() throws IOException {
        //return new HermesDHT<K, V>(null);
        return createDHT(null);
    }

    public <K extends Serializable, V extends Serializable> DHT<K, V> createDHT(String ownerId) throws IOException {
        return new HermesDHT<K, V>(ownerId);
    }
}
