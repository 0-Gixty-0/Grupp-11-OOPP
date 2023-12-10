package com.group11.application;

import java.util.ArrayList;
import java.util.List;

import com.group11.model.gameentites.AEntity;
import com.group11.model.gameentites.CommandableEntity;
import com.group11.model.gameentites.IHasWeapon;
import com.group11.model.gameentites.ProjectileEntity;
import com.group11.model.utility.UEntityCollisionUtility;
import com.group11.view.uicomponents.GamePanel;

/**
 * Class responsible for handling projectiles for the SailingGameApplication class.
 */
public final class UProjectileUtility {

    /**
     * Private constructor to prevent instantiation.
     */
    private UProjectileUtility() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Checks if any projectiles are colliding with any entities and deals damage to the entity if so
     */
    public static void checkProjectileCollisions(List<AEntity> entityList, List<CommandableEntity> enemyList, CommandableEntity player, GamePanel gameView, int waveNumber) {
        
        for (AEntity entity : entityList) {
            AEntity collidingEntity = UEntityCollisionUtility.isEntityColliding(entity);
            if (collidingEntity != null && collidingEntity instanceof ProjectileEntity)  {
                entity.takeDamage(((ProjectileEntity) collidingEntity).getDamage());
                if (entity.getHitPoints() <= 0 && !entity.isFriendly()) {
                    ScoreBoard.incrementScore(player, waveNumber*10);
                    gameView.updateScore(ScoreBoard.getScore(player));
                }
            }
        }
        entityList.removeIf(e -> e.getHitPoints() <= 0);
        enemyList.removeIf(e -> e.getHitPoints() <= 0);
    }

    /**
     * Creates a list of projectiles from the entity list
     */
    public static void updateProjectiles(List<AEntity> entityList) {
        List<AEntity> projectiles = new ArrayList<>();
        for (AEntity entity : entityList) {
            if (entity.getBody() instanceof IHasWeapon) {
                ((IHasWeapon) entity.getBody()).getWeapon().removeOutOfRangeProjectiles();
                projectiles.addAll(((IHasWeapon) entity.getBody()).getWeapon().getFiredProjectiles());
            }
        }
        entityList.removeIf(e -> e instanceof ProjectileEntity && ((ProjectileEntity) e).isOutOfRange());
        entityList.addAll(projectiles);
    }

    /**
     * Moves all projectiles in the entity list
     */
    public static void moveProjectiles(List<AEntity> entityList) {
        for (AEntity entity : entityList) {
            if (entity instanceof ProjectileEntity) {
                ((ProjectileEntity) entity).moveInTravelPath();
            }
        }
    }
}
