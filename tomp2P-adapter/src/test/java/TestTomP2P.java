import fr.univnantes.hermes.tomp2p.TomP2PService;
import net.tomp2p.peers.Number160;

import fr.univnantes.hermes.api.DHT;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TestTomP2P {

    TomP2PService toms = new TomP2PService();
    DHT dhttest = toms.createDHT();

    public TestTomP2P() throws IOException {
    }

    @Test
    public void testaddpeer() throws Exception{


        Number160 num = new Number160(14);
        dhttest.store(14,"bittersweet");

        //System.out.println("La valeur retournée :"+dhttest.retrieve(14));
        Object res = dhttest.retrieve(14);
        System.out.println(res.toString());
        Assert.assertEquals("bittersweet",res.toString());


    }

    @Test(expected=NullPointerException.class)
    public void testremovepeer() throws Exception{

        dhttest.remove(14);
        Assert.fail(dhttest.retrieve(14).toString());

    }



}
