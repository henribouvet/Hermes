package fr.univnantes.hermes.api.base;

import fr.univnantes.hermes.api.DHT;
import fr.univnantes.hermes.api.DHTService;

import java.io.Serializable;

public class NullDHTService implements DHTService {

    public <K extends Serializable, V extends Serializable> DHT<K, V> createDHT() {
        return new NullDHT<K, V>();
    }
}
