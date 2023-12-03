package com.group11.model.gameworld;

/**
 * BasicWorldGenerator is a class that implements the IWorldGenerator interface. It generates a basic world using a map generator.
 */
public class BasicWorldGenerator implements IWorldGenerator {

    IMapGenerator mapGenerator;

    /**
     * Constructor for a BasicWorldGenerator
     * @param mapGenerator the map generator to use for generating the world
     */
    public BasicWorldGenerator(IMapGenerator mapGenerator) {
        this.mapGenerator = mapGenerator;
    }

    /**
     * Method for generating a World object.
     * @param mapWidth the width of the world.
     * @param mapHeight the height of the world.
     * @return a World object 
     */
    @Override
    public World generateWorld(int mapWidth, int mapHeight) {

        Map map = this.mapGenerator.generateMap(mapWidth, mapHeight);

        return new World(map);

    }
    
}