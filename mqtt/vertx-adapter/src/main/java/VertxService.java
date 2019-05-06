import fr.univnantes.hermes.api.MQTT;
import fr.univnantes.hermes.api.MQTTService;

import java.io.IOException;

public class VertxService implements MQTTService {
    @Override
    public MQTT createMQTT() {
        return new VertxAdapter();
    }
}
