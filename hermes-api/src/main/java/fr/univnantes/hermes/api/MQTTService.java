package fr.univnantes.hermes.api;

import java.io.IOException;

public interface MQTTService {
    /**
     * Service name
     */
    String NAME = "MQTTService";

    /**
     *
     * @return
     */
    MQTT createMQTT() throws IOException;
}
