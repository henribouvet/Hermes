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
        dhttest.store(num,"ta daronne");
        String res = String.valueOf(dhttest.retrieve(num));
        Assert.assertEquals("ta daronne",res); ;

    }



}
