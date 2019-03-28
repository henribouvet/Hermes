import org.fusesource.mqtt.client.BlockingConnection;
import org.fusesource.mqtt.client.MQTT;
import org.fusesource.mqtt.client.QoS;
import org.fusesource.mqtt.client.Topic;

public class Adapteurfusesource implements Mqtt{
    private MQTT client;
    private String broker;
    private String clientId;
    private int Qos = 2;
    private String topic;
    private BlockingConnection connection;

    public Adapteurfusesource() {
        this.broker = "tcp://iot.eclipse.org:1883";
        this.clientId = "test";
        this.topic = "MQTT Examples";
    }

    public void connect() {
        try {
            connection = client.blockingConnection();
            client.setClientId(clientId);
            client.setHost(broker);
            connection.connect();
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
            connection.publish(topic, content.getBytes(), qos, false);
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
            connection.subscribe(sujets);
        } catch (Exception e) {
            System.out.println("error on subscribe");
        }
    }

    public void unsubscribe(String[] topics) {
        try {
            connection.unsubscribe(topics);
        } catch (Exception e) {
            System.out.println("error on unsubscribe " + e);
        }
    }
    public void disconnect() {
        try {
            connection.disconnect();
        } catch (Exception e) {
            System.out.println("Disconnect issue " + e);
        }
    }
}
