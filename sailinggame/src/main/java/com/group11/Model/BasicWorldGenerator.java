package com.group11.Model;

public class BasicWorldGenerator extends AWorldGenerator {

    @Override
    public World generateWorld(AMapGenerator mapGenerator) {

        Map map = mapGenerator.generateMap(100);

        World world = new World(map);

        return world;
    }
    
}
