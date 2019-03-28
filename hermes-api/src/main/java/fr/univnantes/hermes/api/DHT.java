package fr.univnantes.hermes.api;

/*
 * Copyright (c) 2016-2017 Atlanmod INRIA LINA Mines Nantes.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Atlanmod INRIA LINA Mines Nantes - initial API and implementation
 */

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * DHT is a simple interface for using Distributed Hash Tables.
 *
 * @param <K> The type of the keys
 * @param <V> The type of the values
 */
@ParametersAreNonnullByDefault
public interface DHT<K extends Serializable, V extends Serializable> {

    /**
     * Stores an object in this DHT.
     */
    @ParametersAreNonnullByDefault
    K store(K key, V value) throws IOException;

    /**
     * Retrieves an object from this DHT.
     */
    @ParametersAreNonnullByDefault
    Serializable retrieve(K key) throws IOException;

    /**
     * Removes the value store at this key and the key itself from this DHT.
     */
    @ParametersAreNonnullByDefault
    void remove(K key) throws IOException;


    /**
     *
     * @return The ownerId of the table
     */
    String getOwnerId();
}
