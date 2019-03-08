package fr.univnantes.hermes.api;

import fr.univnantes.hermes.api.base.NullDHTService;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class HermesFactory {

    private DHTService dhtService;

    public HermesFactory() {
        this.initialize();
    }

    private void initialize() {
        WeldContainer weld = new Weld().initialize();
        try {
            dhtService = weld.select(DHTService.class).get();
        } catch (IllegalStateException e) {
            // No DHTService found.
            dhtService = new NullDHTService();
        }
    }
}
