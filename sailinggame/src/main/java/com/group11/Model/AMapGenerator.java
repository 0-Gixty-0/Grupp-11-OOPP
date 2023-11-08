package com.group11.Model;

import java.io.NotActiveException;
import java.security.InvalidAlgorithmParameterException;

/**
 * AMapGenerator is an abstract baseclass for all types of
 * MapGenerators, it represents the abstract idea of
 * what a MapGenerator is/does (interface).
 */
public abstract class AMapGenerator {

    /**
     * Method for generating a Map object
     * @param side size of the map sides (map is square)
     * @return (Map) 
     */
    public abstract Map generateMap(Integer side);

    /**
     * Method for generating a a land (random which one) or sea tile randomly. 
     * @param landBias a paramater for how big the probability of land should be, sea is therefore P(1-landBias).
     * @return (Atile) returns a random tile
     * @throws NotActiveException
     */
    public ATile randomTile(double landBias) throws NotActiveException {
        throw new NotActiveException("Not implemented");
    }
}
