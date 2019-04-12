package fr.univnantes.hermes.api;

public interface MQTT {
    void connect();

    void publish(String topic, String content, int Qospub);

    void subscribe(String[] topics, int[] qos);

    void unsubscribe(String[] topics);

    void disconnect();
}
