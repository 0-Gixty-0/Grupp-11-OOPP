package com.group11.model.modelinitialization;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.group11.model.builders.EntityDirector;
import com.group11.model.builders.IEntityBuilder;
import com.group11.model.gameentites.AEntity;
import com.group11.model.gameentites.CommandableEntity;
import com.group11.model.gameworld.Map;


/**
 * The EntitySpawner class is responsible for spawning entities in the world.
 * It uses the EntityDirector to create entities and places them at a random position in the world.
 * The position is determined such that it is passable, i.e., an entity can exist at that position.
 */
public final class EntitySpawner {

    private Map map;
    private final EntityDirector director;

    /**
     * Constructs an EntitySpawner with the specified world and director.
     * @param world the game world where entities will be spawned
     * @param builder the director used to create entities
     */
    public EntitySpawner(Map map, IEntityBuilder builder) {
        this.map = map;
        this.director = new EntityDirector(builder);
    }

    /**
     * Spawns an enemy entity at a random passable position in the world.
     * @param level the level of the enemy to be spawned
     * @return the spawned enemy entity
     */
    public AEntity spawnEnemy(int level) {

        Point pos = generateRandomPos();
        while (!posIsPassable(pos)) {
            pos = generateRandomPos();
        }

        return director.createEnemy(pos, level);
    }

    /**
     * Spawns a ship entity at a random passable position in the world.
     * @return the spawned ship entity
     */
    public void changeBuilder(IEntityBuilder builder) {
        this.director.changeBuilder(builder);
    }

    /**
     * Spawns a ship entity at a random passable position in the world.
     * @return the spawned ship entity
     */
    public void changeWorld(Map map) {
        this.map = map;
    }

    /**
     * Spawns a player entity at a random passable position in the world.
     * @return the spawned player entity
     */
    public CommandableEntity spawnPlayer() {

        Point pos = generateRandomPos();
        while (!posIsPassable(pos)) {
            pos = generateRandomPos();
        }
        
        return (CommandableEntity) director.createPlayer(pos);
    }

    /**
     * Checks if a position in the world is passable.
     * @param pos the position to check
     * @return true if the position is passable, false otherwise
     */
    private boolean posIsPassable(Point pos) {
        return map.getTileMatrix().get(pos.x).get(pos.y).isPassable();
    }

    /**
     * Generates a random position in the world.
     * @return the generated position
     */
    private Point generateRandomPos() {
        int y = (int) (Math.random() * this.map.getMapWidth());
        int x = (int) (Math.random() * this.map.getMapHeight());
        return new Point(x, y);
    }

    /**
     * This algorithm creates a list of enemy entities based on the desired wave
     * @param waveNumber The wave number for which to generate
     * @return A list of enemies
     */
    public List<CommandableEntity> createEnemyWave(int waveNumber) {
        ArrayList<CommandableEntity> enemyList = new ArrayList<>();
        // The lower limit for the enemy level increases by one every three waves
        int enemyLevel = (int) (1 + Math.floor(waveNumber/3));
        int maximumEnemies = 20;

        // Decreasing order so that more low level enemies are created than high level ones
        for (int i = waveNumber; i >= 0; i--) {
            // The factor in which to increase the number of enemies per wave
            int numEnemies = (int) Math.floor(1.2 * i);
            // Checks so that the number of enemies does not exceed the maximum amount allowed
            numEnemies = Math.min(numEnemies, maximumEnemies - enemyList.size());
            for (int j = 0; j < numEnemies; j++) {
                enemyList.add((CommandableEntity) this.spawnEnemy(enemyLevel));
            }
            enemyLevel++;
            if (enemyList.size() >= maximumEnemies) {
                break;
            }
        }
        return enemyList;
    }
}