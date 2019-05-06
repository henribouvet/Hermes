import fr.univnantes.hermes.api.MQTT;
import fr.univnantes.hermes.api.MQTTService;

public class PahoService implements MQTTService {
    @Override
    public MQTT createMQTT() {
        return new PahoAdapter();
    }
}
