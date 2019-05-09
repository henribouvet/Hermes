import fr.univnantes.hermes.api.DHT;
import fr.univnantes.hermes.api.DHTService;
import fr.univnantes.hermes.api.api.Key20;
import fr.univnantes.hermes.kademlia.KademliaService;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.function.Executable;

import java.io.IOException;
import java.io.Serializable;


class KademliaAdapterTest {

    private DHT<Serializable, Serializable> dht;
    private DHTService service;
    private Key20 k1, k2;

    @BeforeEach
    void setup() throws IOException {
        service = new KademliaService();
        dht = service.createDHT();
        k1 = new Key20();
        k2 = new Key20();

    }

    @AfterEach
    void shutdown(){
        service.shutDownServer();
    }


    // Just to test if the Key20 is accepted as a key in Kademlia
    @Test
    void TestKey20() throws IOException {
        Key20 key = new Key20();
        dht.store(key.getString(),"Hey");

    }

    @Test
    void TestStoreRetrieve() throws IOException, NoSuchFieldException {
        dht.store(k1.getString(),"Hey");
        assertEquals("Hey", dht.retrieve(k1.getString()));


        dht.store(k2.getString(),"Brother");
        assertEquals("Hey", dht.retrieve(k1.getString()));
        assertEquals("Brother", dht.retrieve(k2.getString()));
    }

    @Test
    void TestRemove() throws IOException, NoSuchFieldException {
        dht.store(k1.getString(),"Hey");
        assertEquals("Hey", dht.retrieve(k1.getString()));

        dht.remove(k1.getString());
        assertThrows(NoSuchFieldException.class, () -> dht.retrieve(k1.getString()));
    }

}
