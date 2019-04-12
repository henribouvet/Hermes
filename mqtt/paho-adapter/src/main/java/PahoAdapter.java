import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import java.util.UUID;


public class Adapteurpaho implements Mqtt {
    private MqttClient client;
    private String broker;
    private String clientId;
    private int Qos = 2;
    private String topic;
    //    private String content = "Message from MqttPublishSample";
    MemoryPersistence persistence = new MemoryPersistence(); //sauvegarde memoire

    public Adapteurpaho() {
        this.broker = "tcp://iot.eclipse.org:1883";
        this.clientId = "test" + UUID.randomUUID().toString();;
        this.topic = "MQTT Examples";
    }

    public void connect() {
        try {
            client = new MqttClient(broker, clientId);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: "+broker);
            client.connect();
            System.out.println("Connected");
        } catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }
    }

    public void publish(String topic, String content, int Qospub) {
        MqttMessage message = new MqttMessage(content.getBytes());

        message.setQos(Qospub);
        try {
            System.out.println("Publishing message: "+content);
            client.publish(topic, message);
            System.out.println("Message published");
        } catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }
    }

    public void subscribe(String[] topics) {

        try {
            client.subscribe(topics);
        } catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }
    }

    public void subscribe(String[] topics, int[] qos) {

        try {
            client.subscribe(topics, qos);
        } catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }
    }

    public void unsubscribe(String[] topics) {
        try {
            client.unsubscribe(topics);
        } catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            client.disconnect();
            System.out.println("Disconnected");
        } catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }
    }

    public void connack(){};
    public void puback(){};
    public void pubrel(){};
    public void pubcomp(){};
    public void suback(){};
    public void pingreq(){};

}
