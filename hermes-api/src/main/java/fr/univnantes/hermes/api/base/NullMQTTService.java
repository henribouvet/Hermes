package fr.univnantes.hermes.api.base;

import fr.univnantes.hermes.api.MQTT;
import fr.univnantes.hermes.api.MQTTService;

public class NullMQTTService implements MQTTService {
    public MQTT createMQTT() {
        return null;
    }
}
