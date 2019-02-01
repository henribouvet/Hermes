package org.atlanmod.hermes.base;

import org.atlanmod.hermes.DHT;
import org.atlanmod.hermes.DHTService;

import java.io.Serializable;

public class NullDHTService implements DHTService {

    public <K extends Serializable, V extends Serializable> DHT<K, V> createDHT() {
        return new NullDHT<K, V>();
    }
}
