package fr.univnantes.hermes.api;

import fr.univnantes.hermes.api.base.NullMQTT;
import fr.univnantes.hermes.api.base.NullMQTTService;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import java.io.IOException;

public class MQTTFactory {
    private MQTTService service;

    public MQTTFactory() {
        this.initialize();
    }

    private void initialize() {
        WeldContainer weld = new Weld().initialize();
        try {
            service = weld.select(MQTTService.class).get();
        } catch (IllegalStateException e) {
            // No DHTService found.
            service = new NullMQTTService();
        }
    }
}

