package fr.univnantes.hermes.tomp2p;

import net.tomp2p.dht.*;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FuturePutGetRemoveAdapter<T> implements Future<T> {
    FuturePut futureput;
    FutureGet futureget;
    FutureRemove futureremove;

    public FuturePutGetRemoveAdapter() {
        futureput = null;
        futureget = null;
        futureremove = null;
    }

    public void setPut(FuturePut futurePut){
        futureput = futurePut;
    }

    public void setGet(FutureGet futureGet) {
        futureget = futureGet;
    }

    public void setRemove(FutureRemove futureRemove) {
        futureremove = futureRemove;
    }

    public boolean cancel(boolean mayInterruptIfRunning) {
        return mayInterruptIfRunning;
    }

    public boolean isCancelled() {
        return false;
    }

    public FutureGet getFutureget() {
        return futureget;
    }

    public FuturePut getFutureput() {
        return futureput;
    }

    public FutureRemove getFutureremove() {
        return futureremove;
    }

    public boolean isDone() {
        return true;
    }

    public Object getData() throws IOException, ClassNotFoundException {
        return futureget.data().object();
    }
    public T get() throws InterruptedException, ExecutionException {
        return null;
    }

    public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }
}
