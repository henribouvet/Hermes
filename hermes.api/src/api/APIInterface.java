package api;

import adapters.Adapters;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.concurrent.Future;

public class APIInterface<K extends Serializable, V extends Serializable> {

    @Inject
    private Adapters adapter;





}