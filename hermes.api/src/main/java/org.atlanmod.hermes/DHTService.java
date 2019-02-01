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
package org.atlanmod.hermes;

import java.io.Serializable;

import javax.annotation.ParametersAreNonnullByDefault;


/**
 * The interface defining the Distributed Hash Table (DHT) service.
 */
@ParametersAreNonnullByDefault
public interface DHTService {
    /**
     * Service name
     */
    String NAME = "DHTService";

    /**
     *
     * @return
     */
    <K extends Serializable, V extends Serializable> DHT<K,V> createDHT();
}

