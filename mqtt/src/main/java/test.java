public class test {
    public static void main(String[] args) {
        Adapteurpaho adapt = new Adapteurpaho();
        //Adapteurxenqtt adapt = new Adapteurxenqtt();
        //Adapteurvertx adapt = new Adapteurvertx();
       // Adapteurfusesource adapt = new Adapteurfusesource();

        adapt.connect();
        adapt.publish("dadzetez", "dada", 2);
        //suscribe a tester
        adapt.disconnect();
    }
}
