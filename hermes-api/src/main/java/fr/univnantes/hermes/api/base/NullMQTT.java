package fr.univnantes.hermes.api.base;

import fr.univnantes.hermes.api.MQTT;

public class NullMQTT implements MQTT {
    public void connect() {
        return;
    }

    public void publish(String topic, String content, int Qospub) {
        return;
    }

    public void subscribe(String[] topics, int[] qos) {
        return;
    }

    public void unsubscribe(String[] topics) {
        return;
    }

    public void disconnect() {
        return;
    }
}
