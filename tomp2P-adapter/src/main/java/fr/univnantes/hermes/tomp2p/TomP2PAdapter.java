package fr.univnantes.hermes.tomp2p;

import fr.univnantes.hermes.api.base.HermesDHTService;
import net.tomp2p.dht.FutureDHT;
import net.tomp2p.dht.FutureGet;
import net.tomp2p.dht.PeerDHT;
import net.tomp2p.futures.BaseFuture;
import net.tomp2p.p2p.Peer;
import fr.univnantes.hermes.api.DHT;
import net.tomp2p.p2p.PeerBuilder;
import net.tomp2p.peers.Number160;

import java.io.IOException;
import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.Future;
import net.tomp2p.dht.DHTBuilder;
import net.tomp2p.storage.Data;

public class TomP2PAdapter implements DHT<Serializable, Serializable> {

    DHTBuilder dhtbuilder;
    PeerDHT peer;
    FutureDHT f;
    FutureGet fg;

    public TomP2PAdapter(PeerDHT peerdht) throws IOException {

        this.peer = peerdht;
      //  dhtbuilder = new DHTBuilder(peer) ;
    }

    public boolean store(Serializable data) throws IOException {
        //return this.tomp2pDHT.store(this.tomp2pDHT.getOwnerId(), data.toString());
        return false;
    }

    public String retrieve(Object key) {
        fg = peer.get((Number160) key).start();

        return fg.data().toString();
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

    public Serializable store(Serializable key, Serializable value) throws IOException {

        //peer.store(Number160.createHash(key)).setObject(value).build();
        return null;

    }

    public Serializable retrieve(Serializable key) throws IOException {
        //FutureDHT<Serializable> answer = peer.get(Number160.createHash(“key”)).build();
        System.out.println("VALEUR DE NUMBER KEY"+(Number160)key);
        fg = peer.get((Number160)key).start();
        System.out.println("VALEUR DE DATA"+fg.data());
        return (Serializable) fg.data(); //new FutureAdapter(answer);
    }

    public void remove(Serializable key) throws IOException {

    }
    public String getOwnerId() {
        return null;
    }
}
