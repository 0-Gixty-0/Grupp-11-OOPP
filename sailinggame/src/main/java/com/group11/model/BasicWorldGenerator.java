package com.group11.model;

/**
 * BasicWorldGenerator is a class that implements the IWorldGenerator interface. Generating a basic world from a mapgenerator.
 */
public class BasicWorldGenerator implements IWorldGenerator {

    IMapGenerator mapGenerator;

    /**
     * Constructor for a BasicWorldGenerator
     * @param mapGenerator the mapgenerator to use for generating the world
     */
    public BasicWorldGenerator(IMapGenerator mapGenerator) {
        this.mapGenerator = mapGenerator;
    }

    /**
     * Method for generating a World object.
     * @param side the size of the side of the square world.
     * @return (World) 
     */
    @Override
    public World generateWorld(Integer side) {

        Map map = this.mapGenerator.generateMap(side);

        return new World(map);

    }
    
}
