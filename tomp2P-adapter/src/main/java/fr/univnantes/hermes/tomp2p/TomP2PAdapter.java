package fr.univnantes.hermes.tomp2p;

import net.tomp2p.dht.FutureDHT;
import net.tomp2p.p2p.Peer;
import net.tomp2p.peers.Number160;
import org.atlanmod.hermes.DHT;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.Future;

public class TomP2PAdapter implements DHT<Serializable, Serializable> {
    private Peer peer;

    public TomP2PAdapter(Peer peer) {
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

    public void store(Serializable key, Serializable value) throws IOException {

        //peer.put(Number160.createHash(key)).setObject(value).build();

    }

    public Future<Serializable> retrieve(Serializable key) throws IOException {
        //FutureDHT<Serializable> answer = peer.get(Number160.createHash(“key”)).build();
        return null; //new FutureAdapter(answer);
    }

    public void remove(Serializable key) throws IOException {

    }
}
