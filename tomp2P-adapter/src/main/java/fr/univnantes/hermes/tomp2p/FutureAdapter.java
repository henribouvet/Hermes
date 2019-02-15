package fr.univnantes.hermes.tomp2p;

import net.tomp2p.dht.FutureDHT;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureAdapter<T> implements Future<T> {

    public FutureAdapter(FutureDHT futureDHT) {
    }

    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return false;
    }

    public T get() throws InterruptedException, ExecutionException {
        return null;
    }

    public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }
}
