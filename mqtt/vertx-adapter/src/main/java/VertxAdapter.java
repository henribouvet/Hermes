import fr.univnantes.hermes.api.MQTT;
import io.netty.handler.codec.mqtt.MqttQoS;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.mqtt.MqttClient;

import java.util.ArrayList;
import java.util.List;

import static io.vertx.core.Vertx.vertx;

//fixer le constructeur
public class VertxAdapter implements MQTT {
    private MqttClient client;
    private String broker;
    private int port;
    private boolean connecteda;

    public VertxAdapter() {
        client = MqttClient.create(vertx());
        this.broker = "iot.eclipse.org";
        this.port = 1883;
        this.connecteda = false;
    }

    public void connect() {
        client.connect(port, broker, s -> {
            if (s.succeeded()) {
                System.out.println("Connected to a server");

                client.publish(
                        "/my_topic",
                        Buffer.buffer("Hello Vert.x MQTT Client"),
                        MqttQoS.AT_MOST_ONCE,
                        false,
                        false,
                        x -> client.disconnect(d -> System.out.println("Disconnected from server")));
            } else {
                System.out.println("Failed to connect to a server");
                System.out.println(s.cause());
            }
        });
    }

    public void publish(String topic, String content, int Qospub) {
        while(this.connecteda)
        //MqttQoS qos = qos.valueOf(Qospub);
        client.publish("topic", Buffer.buffer(content), MqttQoS.AT_MOST_ONCE, false, false); //last 2 is duplicate, needs to be retained?
    }

    public void publish(String topic, String content) {
        try {
            client.publish("topic", Buffer.buffer(content), MqttQoS.AT_MOST_ONCE, false, false); //last 2 is duplicate, needs to be retained?
        } catch(Exception e) {
            System.out.println("Erreur publish : " + e );
        }
    }

    public void subscribe(String[] topics, int[] qos) {
        int i = 0;

        for (String t : topics) {
            client.subscribe(t, qos[i]);
            i++;
        }
    }

    public void subscribe(String[] topics) {
        int i = 0;

        for (String t : topics) {
            client.subscribe(t, 0);
            i++;
        }
    }

    public void unsubscribe(String[] topics) {
        for (String t : topics) {
            client.unsubscribe(t);
        }
    }

    public void unsubscribe(String topic) {
        List<String> topics = new ArrayList<String>();

        topics.add(topic);
        for (String t : topics) {
            client.unsubscribe(t);
        }
    }
    public void disconnect() {
        client.disconnect();
    }
}
