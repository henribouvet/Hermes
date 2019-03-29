package fr.univnantes.hermes.api;

import java.io.IOException;

public interface MQTTService {

    MQTT createMQTT() throws IOException;
}
