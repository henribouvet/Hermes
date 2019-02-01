package org.atlanmod.hermes.base;

import org.atlanmod.hermes.DHT;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.Future;

public class NullDHT<K extends Serializable, V extends Serializable> implements DHT<K, V > {

    public void store(K key, V value) throws IOException {

    }

    public Future<V> retrieve(K key) throws IOException {
        return null;
    }

    public void remove(K key) throws IOException {

    }
}
