package com.group11.Model;


/**
 * AMapGenerator is an abstract baseclass for all types of
 * MapGenerators, it represents the abstract idea of
 * what a MapGenerator is/does (interface).
 */
public abstract class AMapGenerator {
    
    /**
     * Method for generating a Map object
     * @return (Map) 
     */
    public abstract Map generateMap();

}
