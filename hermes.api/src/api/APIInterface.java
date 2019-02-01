package api;

import adapters.Adapters;

import java.util.concurrent.Future;

public class APIInterface {

    private Adapters adapter;


    public APIInterface(Adapters adapter) {
        this.adapter = adapter;
    }

    public boolean store(Object data) {

        return adapter.store();
    }

    public Future<Object> retrieve(Object key) {

        return adapter.retrieve(key);
    }

    public boolean put(Object data) {

        return adapter.put(data);
    }

    public Object get(Object key) {


        return adapter.get(key);
    }

    public boolean remove(Object data) {


        return adapter.remove(data);
    }
}