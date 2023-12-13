package com.group11.model.modelinitialization;

import java.util.ArrayList;
import java.util.List;

import com.group11.model.builders.IEntityBuilder;
import com.group11.model.builders.ShipBuilder;
import com.group11.model.gameentites.AEntity;
import com.group11.model.gameentites.CommandableEntity;
import com.group11.model.gameworld.AdvancedMapGenerator;
import com.group11.model.gameworld.BasicWorldGenerator;
import com.group11.model.gameworld.Map;
import com.group11.model.gameworld.World;
import com.group11.model.utility.UEntityMatrixGenerator;

/**
 * Initializes the model for SailingGame.
 */
public class SailingGameModel extends AModelInitialization {

    public SailingGameModel(int worldWidth, int worldHeight) {
        super(worldWidth, worldHeight);
    }

    @Override
    protected World initializeWorld(int worldWidth, int worldHeight) {
        AdvancedMapGenerator mapGenerator = new AdvancedMapGenerator();
        BasicWorldGenerator worldGenerator = new BasicWorldGenerator(mapGenerator);
        return worldGenerator.generateWorld(worldWidth, worldHeight);
    }

    @Override
    protected Map initializeMap() {
        return this.world.getMap();
    }

    @Override
    protected List<CommandableEntity> initializeEnemyList() {
        return this.entitySpawner.createEnemyWave(1);
    }

    @Override
    protected CommandableEntity initializePlayer() {
        return this.entitySpawner.spawnPlayer();
    }

    @Override
    protected List<List<AEntity>> initializeEntityMatrix() {
        int mapWidth = this.map.getMapWidth();
        int mapHeight = this.map.getMapHeight();
        return UEntityMatrixGenerator.createEntityMatrix(mapWidth, mapHeight, this.entityList);
    }

    @Override
    protected AICommander initializeAICommander() {
        return new AICommander(this.entityMatrix);
    }

    @Override
    protected EntitySpawner initializeEntitySpawner() {
        IEntityBuilder builder = new ShipBuilder();
        return new EntitySpawner(this.map, builder);
    }

    @Override
    protected List<AEntity> initializeEntityList() {
        List<AEntity> entityList = new ArrayList<>();
        entityList.addAll(this.enemyList);
        entityList.add(this.player);
        return entityList;
    }
    
}
