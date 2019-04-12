import fr.univnantes.hermes.api.MQTT;
import net.sf.xenqtt.client.*;
import net.sf.xenqtt.message.ConnectReturnCode;
import net.sf.xenqtt.message.QoS;
import net.sf.xenqtt.client.PublishMessage;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class XenqttAdapter implements MQTT {
    private String broker;
    private String clientId;
    private AsyncMqttClient client;
    private String topic;
    private final CountDownLatch connectLatch = new CountDownLatch(1); //timer d'attente
    private final AtomicReference<ConnectReturnCode> connectReturnCode = new AtomicReference<ConnectReturnCode>(); //return code du broker = ACCEPTED sinon deconnexion



    AsyncClientListener listener = new AsyncClientListener(){
        public void publishReceived(MqttClient client, PublishMessage message) {
        }

        public void disconnected(MqttClient client, Throwable cause, boolean reconnecting) {
        }

        public void connected(MqttClient client, ConnectReturnCode returnCode) {
            connectReturnCode.set(returnCode);
            connectLatch.countDown();
        }

        public void subscribed(MqttClient client, Subscription[] requestedSubscriptions, Subscription[] grantedSubscriptions, boolean requestsGranted) {
        }

        public void unsubscribed(MqttClient client, String[] topics) {
        }

        public void published(MqttClient client, PublishMessage message) {
        }
    };

    public XenqttAdapter() {
        this.broker = "tcp://mqtt-broker:1883";
        this.clientId = "test";
        this.topic = "MQTT Examples";
    }

    public void connect() {
        client = new AsyncMqttClient(broker, listener, 5);

        try {
            client.connect(clientId, true);
            ConnectReturnCode returnCode = connectReturnCode.get();
            if (returnCode == null || returnCode != ConnectReturnCode.ACCEPTED) {
                // The broker bounced us. We are done.
                System.out.println("The broker rejected our attempt to connect. Reason: " + returnCode);
                return;
            }
        } catch (Exception e) {
            System.out.println("An exception prevented the connection." + e);
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
            client.publish(new PublishMessage(topic, qos, content));
            System.out.println("Message published");
        } catch (Exception e) {
            System.out.println("An exception prevented the publishing of the full catalog." + e);
        }
    }

    public void subscribe(String[] topics, int[] qos) {
        int i = 0;
        QoS qosub;
        List<Subscription> subscriptions = new ArrayList<Subscription>();

        //peux mieux faire
        for (String t: topics) {
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

            subscriptions.add(new Subscription(t, qosub));
            i++;
        }

        try {
            System.out.println("Publishing message: "+topics);
            client.subscribe(subscriptions);
        } catch (Exception e){
            System.out.println("An exception prevented the full subscribing." + e);
        }
    }

    public void unsubscribe(String[] topics) {
        try {
            System.out.println("Publishing message: "+topics);
            client.unsubscribe(topics);
            System.out.println("Unsubscribed");
        } catch (Exception e){
            System.out.println("An exception prevented the full unsubscribing." + e);
        }
    }

    public void disconnect() {
        try {
            System.out.println("Disconnecting");
            client.disconnect();
            System.out.println("Disconnected");
        } catch (Exception e) {
            System.out.println("An exception prevented the disconnection." + e);
        }
    }
}
