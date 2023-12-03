package com.group11.model.gameworld;

/**
 * IMapGenerator is an interface for all types of
 * MapGenerators. It represents the method contracts for MapGenerators.
 */
public interface IMapGenerator {

    /**
     * Method for generating a Map object
     * @param mapWidth the width of the map.
     * @param mapHeight the height of the map.
     * @return a Map object 
     */
    public Map generateMap(int mapWidth, int mapHeight);

}