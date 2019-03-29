import fr.univnantes.hermes.api.MQTT;
import io.netty.handler.codec.mqtt.MqttQoS;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.mqtt.MqttClient;

import static io.vertx.core.Vertx.vertx;

//fixer le constructeur
public class VertxAdapter implements MQTT {
    private MqttClient client;
    private String broker;
    private int port;

    public VertxAdapter() {
        client = MqttClient.create(vertx());
        this.broker = "iot.eclipse.org";
        this.port = 1883;
    }

    public void connect() {
        client.connect(port, broker, s -> {
            client.disconnect();
        });
    }

    public void publish(String topic, String content, int Qospub) {
        //MqttQoS qos = qos.valueOf(Qospub);
        client.publish("topic", Buffer.buffer(content), MqttQoS.AT_MOST_ONCE, false, false); //last 2 is duplicate, needs to be retained?
    }

    public void subscribe(String[] topics, int[] qos) {
        int i = 0;

        for (String t : topics) {
            client.subscribe(t, qos[i]);
            i++;
        }
    }

    public void unsubscribe(String[] topics) {
        for (String t : topics) {
            client.unsubscribe(t);
        }
    }

    public void disconnect() {
        client.disconnect();
    }
}
