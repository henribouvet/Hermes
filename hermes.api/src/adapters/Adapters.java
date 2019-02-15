package adapters;

import java.io.Serializable;
import java.util.concurrent.Future;

public interface Adapters {

    void asTomP2P();

    void asKademlia();

    boolean store();

    Future<Object> retrieve(Object key);

    boolean put(Object data);

    Future<Object> get(Object key);

    boolean remove(Object data);
}
