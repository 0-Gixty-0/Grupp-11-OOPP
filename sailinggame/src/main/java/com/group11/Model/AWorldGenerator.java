package com.group11.Model;

/**
 * AWorldGenerator is an abstract baseclass for all types of 
 * WorldGenerators, it represents the abstract idea of
 * what a MapGenerator is/does (interface).
 */
public abstract class AWorldGenerator {
    
    /**
     * Method for generating a World object.
     * @param side the size of the side of the square world.
     * @return (World) 
     */
    public abstract World generateWorld(Integer side);

}
