package fr.univnantes.hermes.api.api;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Random;

public class Key20 implements Serializable {

    private byte[] value;
    private String data;

    public Key20() {
        value = new byte[20];
        (new Random()).nextBytes(value);
        data = RandomStringUtils.randomNumeric(20);
    }

    public byte[] get() {
        return value;
    }
    public String getString() {
        return data;
    }

    public void set(Serializable value) {
        this.value = SerializationUtils.serialize(value);
    }
}
