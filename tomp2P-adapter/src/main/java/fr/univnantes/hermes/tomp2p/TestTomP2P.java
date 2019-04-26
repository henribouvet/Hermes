package fr.univnantes.hermes.tomp2p;
import net.tomp2p.peers.Number160;

import fr.univnantes.hermes.api.DHT;
import org.junit.Assert;
import org.junit.Test;

public class TestTomP2P {


    @Test
    public void testaddpeer() throws Exception{

        TomP2PService toms = new TomP2PService();
        DHT dhttest = toms.createDHT();
        Number160 num = new Number160(14);
        dhttest.store(14,"bittersweet");

        //System.out.println("La valeur retournée :"+dhttest.retrieve(14));
        Object res = dhttest.retrieve(14);
        System.out.println(res.toString());
        Assert.assertEquals("bittersweet",res.toString());

    }



}
