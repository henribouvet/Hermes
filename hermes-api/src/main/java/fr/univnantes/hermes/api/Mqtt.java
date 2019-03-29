package fr.univnantes.hermes.api;

public interface Mqtt {
    public void connect();

    //public void connack();

    // eventuellement rajouter un int pour le QoS
    public void publish(String topic, String content, int Qospub);

    //public void puback();

    //public  void pubrel();

    //public  void pubcomp();

    public  void subscribe(String[] topics, int[] qos);

//    public  void suback();

    public  void unsubscribe(String[] topics);

    //  public  void pingreq();

    public  void disconnect();
}
