package com.app.rickandmorty.common;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * The Class PodamSingleton.
 */
public class PodamWebSingleton {

    /** The podam factory. */
    private static PodamFactory podamFactory = new PodamFactoryImpl();

    /**
     * Instantiates a new podam singleton.
     */
    private PodamWebSingleton() {

    }

    /**
     * Gets the podam factory.
     *
     * @return the podam factory
     */
    public static PodamFactory getPodamFactory() {
        return podamFactory;
    }

}
