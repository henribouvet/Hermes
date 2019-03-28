package fr.univnantes.hermes.api.base;

import fr.univnantes.hermes.api.DHT;

import java.io.IOException;
import java.io.Serializable;

public class NullDHT<K extends Serializable, V extends Serializable> implements DHT<K, V > {

    public K store(K key, V value) throws IOException {

        return null;
    }

    public Serializable retrieve(K key) throws IOException {
        return null;
    }

    public void remove(K key) throws IOException {

    }

    public String getOwnerId() {
        return null;
    }
}
