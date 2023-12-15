package com.group11.model.modelinitialization;

import java.util.List;

import com.group11.model.gameentites.AEntity;
import com.group11.model.gameentites.CommandableEntity;
import com.group11.model.gameentites.UProjectile;
import com.group11.model.gameworld.Map;
import com.group11.model.utility.UEntityMatrixGenerator;

/**
 * The SailingGameLoop class is responsible for running the game loop for the SailingGame application.
 */
public class SailingGameLoop implements IGameLoop {
    
    AICommander aiCommander;
    EntityManager entityManager;
    PlayerManager playerManager;
    Map map;
    List<List<AEntity>> entityMatrix;
    List<CommandableEntity> enemyList;
    List<AEntity> entityList;
    EntitySpawner entitySpawner;
    CommandableEntity player;
    int waveNumber;

    public SailingGameLoop(AModelInitializer initializedModel) {
        this.waveNumber = 1;
        this.map = initializedModel.getMap();
        this.enemyList = initializedModel.getEnemyList();
        this.player = initializedModel.getPlayer();
        this.entityMatrix = initializedModel.getEntityMatrix();
        this.aiCommander = initializedModel.getAICommander();
        this.entitySpawner = initializedModel.getEntitySpawner();
        this.entityList = initializedModel.getEntityList();
        this.playerManager = initializedModel.getPlayerManager();
        this.entityManager = initializedModel.getEntityManager();
    }

    @Override
    public void runLoopOnce(int movementInput, int fireInput) {

        if (enemyList.isEmpty()) {
            waveNumber++;
            enemyList.addAll(entitySpawner.createEnemyWave(waveNumber));
            entityList.addAll(enemyList);
            player.setHitPoints(112);
        }

        playerManager.updatePlayer(movementInput, fireInput);
        aiCommander.moveEnemies(enemyList);
        aiCommander.fireWeapons(enemyList);

        UProjectile.updateProjectiles(entityList); // Adds new projectiles to an entity list and removes old dead projectiles.

        UProjectile.moveProjectiles(entityList); // Moves the projectiles.
        UEntityMatrixGenerator.updateEntityMatrix(entityList); // Updates the entity matrix.
        UProjectile.checkProjectileCollisions(entityList); // Checks for collisions.
        
        // Two iterations so that projectiles move faster than other entities.
        UProjectile.moveProjectiles(entityList);
        UEntityMatrixGenerator.updateEntityMatrix(entityList);
        UProjectile.checkProjectileCollisions(entityList);
        
        // Removes dead entities
        entityManager.removeEntitiesWithZeroHp(waveNumber);
    }

    @Override
    public boolean isGameOver() {
        return player.getHitPoints() <= 0;
    }
}