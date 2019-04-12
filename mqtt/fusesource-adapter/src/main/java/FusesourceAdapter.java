import fr.univnantes.hermes.api.MQTT;
import org.fusesource.mqtt.client.BlockingConnection;
import org.fusesource.mqtt.client.QoS;
import org.fusesource.mqtt.client.Topic;

public class FusesourceAdapter implements MQTT {
    private org.fusesource.mqtt.client.MQTT client;
    private String broker;
    private String clientId;
    private int Qos = 2;
    private String topic;
    private BlockingConnection connection;

    public FusesourceAdapter() {
        this.broker = "tcp://iot.eclipse.org:1883";
        this.clientId = "test";
        this.topic = "MQTT Examples";
    }

    public void connect() {
        try {
            System.out.println("Connecting to broker: "+broker);
            connection = client.blockingConnection();
            client.setClientId(clientId);
            client.setHost(broker);
            connection.connect();
            System.out.println("Connected");
        } catch (Exception e) {
            System.out.println("erreur connexion" + e);
        }
    }

    public void publish(String topic, String content, int Qospub) {
        QoS qos;

        switch (Qospub) {
            case 0:
                qos = QoS.AT_LEAST_ONCE;
                break;
            case 1:
                qos = QoS.AT_MOST_ONCE;
                break;
            case 2:
                qos = QoS.EXACTLY_ONCE;
                break;
            default:
                qos = QoS.EXACTLY_ONCE;
        }

        try {
            System.out.println("Publishing message: "+content);
            connection.publish(topic, content.getBytes(), qos, false);
            System.out.println("Message published");
        } catch (Exception e) {
            System.out.println("error on publish " + e);
        }
    }

    public void subscribe(String[] topics, int[] qos) {
        Topic[] sujets = new Topic[topics.length];
        QoS qosub;
        for (int i = 0; i < sujets.length; i++) {
            Topic t;
            switch (qos[i]) {
                case 0:
                    qosub = QoS.AT_LEAST_ONCE;
                    break;
                case 1:
                    qosub = QoS.AT_MOST_ONCE;
                    break;
                case 2:
                    qosub = QoS.EXACTLY_ONCE;
                    break;
                default:
                    qosub = QoS.EXACTLY_ONCE;
            }
            t = new Topic(topics[i], qosub);
            sujets[i] = t;
        }

        try {
            System.out.println("Subscribing to " + topics);
            connection.subscribe(sujets);
            System.out.println("Subscribed");
        } catch (Exception e) {
            System.out.println("error on subscribe");
        }
    }

    public void unsubscribe(String[] topics) {
        try {
            System.out.println("Unsubscribing to " + topics);
            connection.unsubscribe(topics);
            System.out.println("Unsubscribed");
        } catch (Exception e) {
            System.out.println("error on unsubscribe " + e);
        }
    }
    public void disconnect() {
        try {
            System.out.println("Disconnecting");
            connection.disconnect();
            System.out.println("Disconnected");
        } catch (Exception e) {
            System.out.println("Disconnect issue " + e);
        }
    }
}
