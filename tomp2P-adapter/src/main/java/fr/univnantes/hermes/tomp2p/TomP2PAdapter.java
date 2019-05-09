package fr.univnantes.hermes.tomp2p;

import net.tomp2p.dht.*;
import fr.univnantes.hermes.api.DHT;
import net.tomp2p.peers.Number160;

import java.io.IOException;
import java.io.Serializable;

import net.tomp2p.storage.Data;

public class TomP2PAdapter implements DHT<Serializable, Serializable> {

    DHTBuilder dhtbuilder;
    PeerDHT peer;
    FutureDHT f;
    FutureGet fg;
    FuturePut futurePut;
    FutureRemove fr;

    public TomP2PAdapter(PeerDHT peerdht) throws IOException {

        this.peer = peerdht;
      //  dhtbuilder = new DHTBuilder(peer) ;
    }

    public boolean store(Serializable data) throws IOException {
        //return this.tomp2pDHT.store(this.tomp2pDHT.getOwnerId(), data.toString());
        return false;
    }

   /* public String retrieve(Object key) {
        fg = peer.get((Number160) key).start();

        return fg.data().toString();
    }
*/
    public boolean put(Object data) {
        return false;
    }

    public Object get(Object key) {
        return null;
    }

    public boolean remove(Object data) {
        return false;
    }

    public Serializable store(Serializable key, Serializable value) throws IOException {

        futurePut = peer.put(Number160.createHash((int)key)).data(new Data(value)).start();
        futurePut.awaitUninterruptibly();

        return key;

    }

    public Serializable retrieve(Serializable key) throws IOException {

        fg = peer.get(Number160.createHash((int)key)).start();
        fg.awaitUninterruptibly();

        try {
            return (Serializable) fg.data().object();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void remove(Serializable key) throws IOException {
       fr = peer.remove(Number160.createHash((int)key)).start();
       fr.awaitUninterruptibly();
    }
    public String getOwnerId() {
        return null;
    }
}
