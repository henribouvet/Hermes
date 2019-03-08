package fr.univnantes.hermes.api.adapters;

import java.io.IOException;
import java.util.concurrent.Future;

public interface Adapters {

    boolean store(Object data) throws IOException;

    Future<Object> get(Object key);

    boolean remove(Object data);
}
