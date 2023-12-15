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
 * The SailingGameModel class is responsible for initializing the model for the SailingGame application.
 * It extends the AModelInitializer abstract class and overrides its methods to provide specific implementation for the SailingGame.
 */
public class SailingGameModel extends AModelInitializer {

    /**
     * Constructs a SailingGameModel with the specified world width and height.
     *
     * @param worldWidth  the width of the world
     * @param worldHeight the height of the world
     */
    public SailingGameModel(int worldWidth, int worldHeight) {
        super(worldWidth, worldHeight);
    }

    /**
     * Initializes the world with the specified width and height.
     *
     * @param worldWidth  the width of the world
     * @param worldHeight the height of the world
     * @return the initialized world
     */
    @Override
    protected World initializeWorld(int worldWidth, int worldHeight) {
        AdvancedMapGenerator mapGenerator = new AdvancedMapGenerator();
        BasicWorldGenerator worldGenerator = new BasicWorldGenerator(mapGenerator);
        return worldGenerator.generateWorld(worldWidth, worldHeight);
    }

    /**
     * Initializes the map for the game world.
     *
     * @return the initialized map
     */
    @Override
    protected Map initializeMap() {
        return this.world.getMap();
    }

    /**
     * Initializes the list of enemy entities for the game.
     *
     * @return the initialized list of enemy entities
     */
    @Override
    protected List<CommandableEntity> initializeEnemyList() {
        return this.entitySpawner.createEnemyWave(1);
    }

    /**
     * Initializes the player entity for the game.
     *
     * @return the initialized player entity
     */
    @Override
    protected CommandableEntity initializePlayer() {
        return this.entitySpawner.spawnPlayer();
    }

    /**
     * Initializes the entity matrix for the game.
     *
     * @return the initialized entity matrix
     */
    @Override
    protected List<List<AEntity>> initializeEntityMatrix() {
        int mapWidth = this.map.getMapWidth();
        int mapHeight = this.map.getMapHeight();
        return UEntityMatrixGenerator.createEntityMatrix(mapWidth, mapHeight, this.entityList);
    }

    /**
     * Initializes the AI commander for the game.
     *
     * @return the initialized AI commander
     */
    @Override
    protected AICommander initializeAICommander() {
        return new AICommander(this.entityMatrix);
    }

    /**
     * Initializes the entity spawner for the game.
     *
     * @return the initialized entity spawner
     */
    @Override
    protected EntitySpawner initializeEntitySpawner() {
        IEntityBuilder builder = new ShipBuilder();
        return new EntitySpawner(this.map, builder);
    }

    /**
     * Initializes the list of entities for the game.
     *
     * @return the initialized list of entities
     */
    @Override
    protected List<AEntity> initializeEntityList() {
        List<AEntity> entityList = new ArrayList<>();
        entityList.addAll(this.enemyList);
        entityList.add(this.player);
        return entityList;
    }
}