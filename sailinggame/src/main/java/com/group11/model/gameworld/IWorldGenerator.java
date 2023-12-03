package com.group11.model.gameworld;

/**
 * IWorldGenerator is an interface for all types of WorldGenerators. It represents the method contracts for WorldGenerators.
 */
public interface IWorldGenerator {
    
    /**
     * Method for generating a World object.
     * @param mapWidth the width of the world.
     * @param mapHeight the height of the world.
     * @return a World object 
     */
    public World generateWorld(int mapWidth, int mapHeight);

}