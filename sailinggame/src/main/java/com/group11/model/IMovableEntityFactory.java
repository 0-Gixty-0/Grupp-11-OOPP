package com.group11.model;

/**
 * Interface for a factory creating movable entities
 */
public interface IMovableEntityFactory {
    /**
     * Signature for creating a player
     * @return
     */
    AEntity createPlayer();

    /**
     * Signature for creating an enemy
     * @return
     */
    AEntity createEnemy();

}
