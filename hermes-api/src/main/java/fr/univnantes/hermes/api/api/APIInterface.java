package fr.univnantes.hermes.api.api;


import fr.univnantes.hermes.api.adapters.Adapters;

import javax.inject.Inject;
import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.Future;

public class APIInterface<K extends Serializable, V extends Serializable> {

    @Inject
    private Adapters adapter;


    public boolean put(V value) throws IOException {
        return adapter.store(value);
    }

    public Future<Object> get(K key) {
        return adapter.get(key);
    }

    public boolean remove(V value) {
        return adapter.remove(value);
    }



}