package fr.univnantes.hermes.kademlia;

import fr.univnantes.hermes.api.DHT;
import kademlia.JKademliaNode;
import kademlia.dht.*;
import kademlia.exceptions.ContentNotFoundException;
import kademlia.node.KademliaId;

import javax.annotation.ParametersAreNonnullByDefault;
import java.io.IOException;
import java.io.Serializable;

public class KademliaAdapter implements DHT<Serializable, Serializable> {
    private JKademliaNode kad;

    public KademliaAdapter(JKademliaNode node) throws IOException {
        kad = node;
    }


    /*public Future<Object> retrieve(Object key) {
        return null;
    }

    public boolean remove(Object data) {
        return false;
    }*/

    @ParametersAreNonnullByDefault
    public Serializable store(Serializable key, Serializable value) throws IOException {
        //KadContent content = new DHTContentImpl(new KademliaId((byte[]) key), value.toString());
        //KadContent content = new DHTContentImpl(new KademliaId((byte[]) key), getOwnerId());
        DHTContentImpl content = new DHTContentImpl(new KademliaId((String)key),getOwnerId());
        content.setData(value);
        JKademliaStorageEntry entry = new JKademliaStorageEntry(content);

        this.kad.put(entry);
        // To get the usable KademliaId
        //return content.getKey();
        GetParameter gp = new GetParameter(content);
        gp.setType(DHTContentImpl.TYPE);
        gp.setOwnerId(content.getOwnerId());
        return gp.getKey().toString();
    }

    @ParametersAreNonnullByDefault
    public Serializable retrieve(Serializable key) throws IOException, NoSuchFieldException {
        GetParameter gp;
        if (key.getClass() == String.class)
            gp = new GetParameter(new KademliaId((String) key), DHTContentImpl.TYPE);
        else
            gp = new GetParameter((KademliaId)key, DHTContentImpl.TYPE);
        gp.setOwnerId(getOwnerId());
        try {
             String content = new DHTContentImpl().fromSerializedForm(kad.get(gp).getContent()).toString();

             // Data starts at char 20
             int bracket = 20;
             // To get the "data" substring
             for (int i = 20; i < content.length(); ++i) {
                 if (content.charAt(i) == '{') {
                     bracket = i;
                     break;
                 }
             }
             return content.substring(21, bracket);

        } catch (ContentNotFoundException e) {
            throw new NoSuchFieldException();
        }
    }

    @ParametersAreNonnullByDefault
    public void remove(Serializable key) throws IOException, NoSuchFieldException {
        DHTContentImpl c = getContent(key);
        try {
            kad.getDHT().remove(c);
        } catch (ContentNotFoundException e) {
            throw new NoSuchFieldException();
        }

    }

    private DHTContentImpl getContent(Serializable key) {
        GetParameter gp;
        if (key.getClass() == String.class)
            gp = new GetParameter(new KademliaId((String) key), DHTContentImpl.TYPE);
        else
            gp = new GetParameter((KademliaId)key, DHTContentImpl.TYPE);
        gp.setOwnerId(getOwnerId());
        try {
            DHTContentImpl content = new DHTContentImpl().fromSerializedForm(kad.get(gp).getContent());

            return content;

        } catch (ContentNotFoundException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public String getOwnerId() {
        return this.kad.getOwnerId();
    }

    public void shutDownServer() {
        kad.getServer().shutdown();
    }



}
