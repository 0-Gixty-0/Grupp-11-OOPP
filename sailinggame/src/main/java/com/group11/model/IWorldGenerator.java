package com.group11.model;

/**
 * IWorldGenerator is Interface for all types of WorldGenerators, it represents the method contracts for WorldGenerators.
 */
public interface IWorldGenerator {
    
    /**
     * Method for generating a World object.
     * @param side the size of the side of the square world.
     * @return (World) 
     */
    public World generateWorld(Integer side);

}
