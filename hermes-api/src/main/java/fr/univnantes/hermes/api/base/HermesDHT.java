package fr.univnantes.hermes.api.base;

import fr.univnantes.hermes.api.DHT;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.concurrent.Future;
import javax.annotation.ParametersAreNonnullByDefault;

public class HermesDHT<K extends Serializable, V extends Serializable> implements DHT<K, V> {
    private Map<Serializable, Serializable> map = new HashMap<Serializable, Serializable>();
    private String ownerId;

    public HermesDHT(String ownerId) {
        this.ownerId = ownerId;
    }

    @ParametersAreNonnullByDefault
    public boolean store(Serializable key, Serializable value) {

        return value.equals(this.map.put(UUID.randomUUID().toString().replace("-",""), value));
        //return value.equals(this.map.put(new Random().nextInt(), value));
    }

    @ParametersAreNonnullByDefault
    public Future<V> retrieve(Serializable key) {
        return (Future<V>) this.map.get(key);
    }

    @ParametersAreNonnullByDefault
    public void remove(Serializable key) {
        this.map.remove(key);
    }

    public String getOwnerId() {
        return this.ownerId;
    }

}
