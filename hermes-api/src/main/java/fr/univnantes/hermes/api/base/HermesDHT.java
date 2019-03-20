package fr.univnantes.hermes.api.base;

import fr.univnantes.hermes.api.DHT;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import javax.annotation.ParametersAreNonnullByDefault;

public class HermesDHT<K extends Serializable, V extends Serializable> implements DHT<K, V> {
    private Map<Serializable, Serializable> map = new HashMap();
    private String ownerId;

    public HermesDHT(String ownerId) {
        this.ownerId = ownerId;
    }

    @ParametersAreNonnullByDefault
    public boolean store(Serializable key, Serializable value) throws IOException {
        return value.equals(this.map.put(key, value));
    }

    @ParametersAreNonnullByDefault
    public Future retrieve(Serializable key) throws IOException {
        return (Future)this.map.get(key);
    }

    @ParametersAreNonnullByDefault
    public void remove(Serializable key) throws IOException {
        this.map.remove(key);
    }

    public String getOwnerId() {
        return this.ownerId;
    }
}
