package fr.univnantes.hermes.tomp2p;

import fr.univnantes.hermes.api.base.HermesDHTService;
import net.tomp2p.dht.*;
import net.tomp2p.futures.BaseFuture;
import net.tomp2p.p2p.Peer;
import fr.univnantes.hermes.api.DHT;
import net.tomp2p.p2p.PeerBuilder;
import net.tomp2p.peers.Number160;

import java.io.IOException;
import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.Future;

import net.tomp2p.peers.Number640;
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
        Number160 num = new Number160((int)key);
        Data dt = new Data();

        dhtbuilder = peer.put(Number160.createHash((int)key)).keyObject(Number160.createHash((int)key),value)/*.setObject(“hello world”).build()*/;
        dhtbuilder.start();

       // PutBuilder testputbuilder = new PutBuilder(peer,num);
       // testputbuilder.start();
        //testputbuilder.data(value.toString());
        //peer.put(num).data(.value.toString());
        //peer.store(Number160.createHash(key)).setObject(value).build();
        return num;

    }

    public Serializable retrieve(Serializable key) throws IOException {
        //FutureDHT<Serializable> answer = peer.get(Number160.createHash(“key”)).build();
        System.out.println("VALEUR DE NUMBER KEY"+(Number160)key);

        fg = peer.get((Number160)key).start();

        System.out.println("FG VIDE ? "+fg.dataMap());
       //System.out.println("VALEUR DE DATA"+fg.data().toString());
        return (Serializable) fg.data().toString(); //new FutureAdapter(answer);
    }

    public void remove(Serializable key) throws IOException {

    }
    public String getOwnerId() {
        return null;
    }
}
