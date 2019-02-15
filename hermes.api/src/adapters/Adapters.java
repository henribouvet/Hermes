package adapters;

import java.io.IOException;
import java.util.concurrent.Future;

public interface Adapters {

    boolean put(Object data) throws IOException;

    Future<Object> get(Object key);

    boolean remove(Object data);
}
