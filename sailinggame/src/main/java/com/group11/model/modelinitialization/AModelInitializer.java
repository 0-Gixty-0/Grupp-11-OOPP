package com.group11.model.modelinitialization;

import java.util.List;

import com.group11.model.gameentites.AEntity;
import com.group11.model.gameentites.CommandableEntity;
import com.group11.model.gameworld.Map;
import com.group11.model.gameworld.World;
import com.group11.model.utility.UEntityCollision;
import com.group11.model.utility.UEntityMatrixDecoder;
import com.group11.model.utility.UMovement;
import com.group11.model.utility.UViewTileMatrixDecoder;

/**
 * Abstract class for initializing a model. The AModelInitializer is a
 * facade for the model package that can be used by the application to reduce coupling
 */
public abstract class AModelInitializer {
    
    World world;
    Map map;
    List<CommandableEntity> enemyList;
    List<List<AEntity>> entityMatrix;
    EntitySpawner entitySpawner;
    List<AEntity> entityList;
    CommandableEntity player;
    AICommander aiCommander;
    PlayerManager playerManager;
    EntityManager entityManager;
    int worldWidth;
    int worldHeight;

    protected AModelInitializer(int worldWidth, int worldHeight) {
        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;
        this.world = initializeWorld(worldWidth, worldHeight);
        this.map = initializeMap();
        this.entitySpawner = initializeEntitySpawner();
        this.enemyList = initializeEnemyList();
        this.player = initializePlayer();
        this.entityList = initializeEntityList();
        this.entityMatrix = initializeEntityMatrix();
        UMovement.setTileMatrix(map.getTileMatrix());
        UEntityCollision.setEntityMatrix(entityMatrix);
        UViewTileMatrixDecoder.setTilematrix(map.getTileMatrix());
        UEntityMatrixDecoder.setEntityMatrix(entityMatrix);
        this.aiCommander = initializeAICommander();
        this.playerManager = new PlayerManager(player);
        this.entityManager = new EntityManager(enemyList, entityList, player);
    }

    /**
     * Initializes the world
     * @param worldWidth the width of the world
     * @param worldHeight the height of the world
     * @return the world
     */
    protected abstract World initializeWorld(int worldWidth, int worldHeight);

    /**
     * Initializes the map
     * @return the map
     */
    protected abstract Map initializeMap();

    /**
     * Initializes the enemy list
     * @return the enemy list
     */
    protected abstract List<CommandableEntity> initializeEnemyList();

    /**
     * Initializes the player
     * @return the player
     */
    protected abstract CommandableEntity initializePlayer();

    /**
     * Initializes the entity matrix
     * @return the entity matrix
     */
    protected abstract List<List<AEntity>> initializeEntityMatrix();

    /**
     * Initializes the AI commander
     * @return the AI commander
     */
    protected abstract AICommander initializeAICommander();

    /**
     * Initializes the entity spawner
     * @return the entity spawner
     */
    protected abstract EntitySpawner initializeEntitySpawner();

    /**
     * Initializes the entity list
     * @return the entity list
     */
    protected abstract List<AEntity> initializeEntityList();

    /**
     * Accessor for getting an up to date version of the entity matrix
     * @return the entity matrix in integer format
     */
    public List<List<Integer>> getDecodedEntityMatrix() {
        return UEntityMatrixDecoder.decodeIntoIntMatrix();
    }

    /**
     * Accessor for getting an up to date version of the terrain matrix
     * @return the terrain matrix in integer format
     */
    public List<List<Integer>> getDecodedTerrainMatrix() {
        return UViewTileMatrixDecoder.decodeIntoIntMatrix();
    }

    /**
     * Accessor for getting the player hit points
     * @return the player hit points
     */
    public int getPlayerHitPoints() {
        return player.getHitPoints();
    }

    /**
     * Accessor for getting the player score
     * @return the player score
     */
    public int getPlayerScore() {
        return playerManager.getPlayerScore();
    }

    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    protected PlayerManager getPlayerManager() {
        return this.playerManager;
    }

    protected World getWorld() {
        return this.world;
    }

    protected Map getMap() {
        return this.map;
    }

    protected List<CommandableEntity> getEnemyList() {
        return this.enemyList;
    }

    protected CommandableEntity getPlayer() {
        return this.player;
    }

    protected List<List<AEntity>> getEntityMatrix() {
        return this.entityMatrix;
    }

    protected AICommander getAICommander() {
        return this.aiCommander;
    }

    protected EntitySpawner getEntitySpawner() {
        return this.entitySpawner;
    }

    protected List<AEntity> getEntityList() {
        return this.entityList;
    }
}