package api;

import adapters.Adapters;

import javax.inject.Inject;
import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.Future;

public class APIInterface<K extends Serializable, V extends Serializable> {

    @Inject
    private Adapters adapter;


    public boolean put(V value) throws IOException {
        return adapter.put(value);
    }

    public Future<V> get(K key) {
        return (Future<V>) adapter.get(key);
    }

    public boolean remove(V value) {
        return adapter.remove(value);
    }



}