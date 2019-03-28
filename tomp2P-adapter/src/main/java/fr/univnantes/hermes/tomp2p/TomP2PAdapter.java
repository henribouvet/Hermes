package fr.univnantes.hermes.tomp2p;

import net.tomp2p.p2p.Peer;
import fr.univnantes.hermes.api.DHT;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.Future;

public class TomP2PAdapter implements DHT<Serializable, Serializable> {
    private Peer peer;
    private DHT tomp2pDHT;
    private TomP2PService tomp2pService = new TomP2PService();

    public TomP2PAdapter() throws IOException {
        tomp2pDHT = tomp2pService.createDHT();
    }

    public Serializable store(Serializable data) throws IOException {
        return this.tomp2pDHT.store(this.tomp2pDHT.getOwnerId(), data.toString());
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

    public String store(Serializable key, Serializable value) throws IOException {

        //peer.store(Number160.createHash(key)).setObject(value).build();
        return "";

    }

    public Serializable retrieve(Serializable key) throws IOException {
        //FutureDHT<Serializable> answer = peer.get(Number160.createHash(“key”)).build();
        return null; //new FutureAdapter(answer);
    }

    public void remove(Serializable key) throws IOException {

    }

    public String getOwnerId() {
        return null;
    }
}
