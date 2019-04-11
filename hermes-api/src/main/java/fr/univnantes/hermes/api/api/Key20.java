package fr.univnantes.hermes.api.api;

import java.io.Serializable;
import java.util.Random;

public class Key20 implements Serializable {

    private byte[] value;

    public Key20() {
        value = new byte[20];
        (new Random()).nextBytes(value);
    }

    public Serializable get() {
        return value;
    }
}
