package adapters;

import java.util.concurrent.Future;

public class TomP2PAdapter implements Adapters {

    public void asTomP2P() {

    }

    public void asKademlia() {

    }

    public boolean store() {
        return false;
    }

    public Future<Object> retrieve(Object key) {
        return null;
    }

    public boolean put(Object data) {
        return false;
    }

    public Object get(Object key) {
        return null;
    }

    public boolean remove(Object data) {
        return false;
    }
}
