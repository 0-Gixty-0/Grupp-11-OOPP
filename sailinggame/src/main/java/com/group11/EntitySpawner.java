package com.group11;

import com.group11.model.builders.EntityDirector;
import com.group11.model.gameentites.AEntity;
import com.group11.model.gameworld.World;

import java.awt.*;


/**
 * The EntitySpawner class is responsible for spawning entities in the world.
 * It uses the EntityDirector to create entities and places them at a random position in the world.
 * The position is determined such that it is passable, i.e., an entity can exist at that position.
 */
public class EntitySpawner {

    private final World world;
    private final EntityDirector director;

    /**
     * Constructs an EntitySpawner with the specified world and director.
     * @param world the game world where entities will be spawned
     * @param director the director used to create entities
     */
    public EntitySpawner(World world, EntityDirector director) {
        this.world = world;
        this.director = director;
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
     * Spawns a player entity at a random passable position in the world.
     * @param level the level of the player to be spawned
     * @return the spawned player entity
     */
    public AEntity spawnPlayer(int level) {

        Point pos = generateRandomPos();
        while (!posIsPassable(pos)) {
            pos = generateRandomPos();
        }

        return director.createPlayer(pos);
    }

    /**
     * Checks if a position in the world is passable.
     * @param pos the position to check
     * @return true if the position is passable, false otherwise
     */
    public boolean posIsPassable(Point pos) {
        return world.getMap().getTileMatrix().get(pos.x).get(pos.y).isPassable();
    }

    /**
     * Generates a random position in the world.
     * @return the generated position
     */
    public Point generateRandomPos() {
        int x = (int) (Math.random() * this.world.getMap().getMapWidth());
        int y = (int) (Math.random() * this.world.getMap().getMapHeight());
        return new Point(x, y);
    }
}