package com.group11.model;

public class BasicWorldGenerator extends AWorldGenerator {

    AMapGenerator mapGenerator;

    public BasicWorldGenerator(AMapGenerator mapGenerator) {
        this.mapGenerator = mapGenerator;
    }

    @Override
    public World generateWorld(Integer side) {

        Map map = this.mapGenerator.generateMap(side);

        World world = new World(map);

        return world;
    }
    
}
