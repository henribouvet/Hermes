package fr.univnantes.hermes.tomp2p;

import net.tomp2p.dht.*;
import fr.univnantes.hermes.api.DHT;
import net.tomp2p.peers.Number160;

import java.io.IOException;
import java.io.Serializable;

import net.tomp2p.storage.Data;

public class TomP2PAdapter implements DHT<Serializable, Serializable> {

    PeerDHT peer;
    FuturePutGetRemoveAdapter fpra;


    public TomP2PAdapter(PeerDHT peerdht) throws IOException {

        this.peer = peerdht;
        fpra = new FuturePutGetRemoveAdapter();
    }


    public Serializable store(Serializable key, Serializable value) throws IOException {

        fpra.setPut(peer.put(Number160.createHash((int)key)).data(new Data(value)).start());
        fpra.getFutureput().awaitUninterruptibly();

        return key;

    }

    public Serializable retrieve(Serializable key) throws IOException {

        fpra.setGet(peer.get(Number160.createHash((int)key)).start());
        fpra.getFutureget().awaitUninterruptibly();

        try {
            return (Serializable) fpra.getData();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void remove(Serializable key) throws IOException {

        fpra.setRemove(peer.remove(Number160.createHash((int)key)).start());
        fpra.getFutureremove().awaitUninterruptibly();
    }
    public String getOwnerId() {
        return null;
    }
}
