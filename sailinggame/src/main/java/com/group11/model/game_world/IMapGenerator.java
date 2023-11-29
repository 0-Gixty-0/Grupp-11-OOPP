package com.group11.model.game_world;

/**
 * IMapGenerator is Interface for all types of
 * MapGenerators, it represents the method contracts for MapGenerators.
 */
public interface IMapGenerator {

    /**
     * Method for generating a Map object
     * @param side size of the map sides (map is square)
     * @return (Map) 
     */
    public Map generateMap(int side);

}
