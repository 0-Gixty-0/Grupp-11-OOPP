package com.group11.model.modelinitialization;

import java.util.ArrayList;
import java.util.List;

import com.group11.model.gameentites.AEntity;
import com.group11.model.gameentites.CommandableEntity;

/**
 * The EntityManager class is responsible managing the lifecycle of entities in the game. Removing them
 * when they are dead and updating the player score when an enemy is killed.
 */
public class EntityManager {

    private CommandableEntity player;
    private List<CommandableEntity> enemyList;
    private List<AEntity> entityList;

    /**
     * Constructs an EntityManager with a list of enemies, a list of entities, and a player.
     *
     * @param enemyList  the list of enemies
     * @param entityList the list of entities
     * @param player     the player
     */
    public EntityManager(List<CommandableEntity> enemyList, List<AEntity> entityList, CommandableEntity player) {
        this.enemyList = enemyList;
        this.entityList = entityList;
        this.player = player;
    }

    /**
     * Removes entities that have zero or less hit points. If the entity is an enemy, the player's score is incremented.
     * The score increment is based on the current wave number multiplied by 10.
     *
     * @param waveNumber the current wave number
     */
    protected void removeEntitiesWithZeroHp(int waveNumber) {
        List<AEntity> entitiesToRemove = new ArrayList<>();
        for (AEntity entity : entityList) {
            if (entity.getHitPoints() <= 0) {
                if (!entity.isFriendly()) {
                    ScoreBoard.incrementScore(player, waveNumber*10);
                }
                entitiesToRemove.add(entity);
            }
        }
        this.entityList.removeAll(entitiesToRemove);
        this.enemyList.removeAll(entitiesToRemove);
    }
}