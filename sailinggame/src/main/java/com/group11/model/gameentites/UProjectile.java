package com.group11.model.gameentites;

import java.util.ArrayList;
import java.util.List;

import com.group11.model.utility.UEntityCollision;

/**
 * This utility class is responsible for handling projectiles in the SailingGameApplication.
 * It provides methods to check for projectile collisions, update projectiles, and move projectiles.
 * This class is not meant to be instantiated.
 */
public final class UProjectile {

    /**
     * Private constructor to prevent instantiation.
     * Throws an IllegalStateException if an attempt is made.
     */
    private UProjectile() {

        throw new IllegalStateException("Utility class");
    }

    /**
     * Checks if any projectiles are colliding with any entities in the provided list.
     * If a collision is detected, the colliding entity takes damage equal to the projectile's damage.
     *
     * @param entityList The list of entities to check for collisions.
     */
    public static void checkProjectileCollisions(List<AEntity> entityList) {

        for (AEntity entity : entityList) {

            AEntity collidingEntity = UEntityCollision.isEntityColliding(entity);

            if (collidingEntity instanceof ProjectileEntity)  {

                entity.takeDamage(((ProjectileEntity) collidingEntity).getDamage());

            }
        }
    }

    /**
     * Updates the projectile entities in the provided entity list.
     * This involves removing out of range projectiles and adding new ones.
     *
     * @param entityList The list of entities to update.
     */
    public static void updateProjectiles(List<AEntity> entityList) {

        entityList.removeIf(e -> e instanceof ProjectileEntity);

        List<AEntity> projectiles = new ArrayList<>();

        for (AEntity entity : entityList) {

            if (entity instanceof CommandableEntity) {

                AWeapon entityWeapon = ((CommandableEntity) entity).getWeaponIfExists();
                if (entityWeapon != null) {

                    entityWeapon.removeOutOfRangeProjectiles();

                    entityWeapon.removeDeadProjectiles();

                    projectiles.addAll(entityWeapon.getFiredProjectiles());

                }
            }
        }
        entityList.addAll(projectiles);
    }

    /**
     * Moves all projectiles in the provided entity list along their travel paths.
     *
     * @param entityList The list of entities to move.
     */
    public static void moveProjectiles(List<AEntity> entityList) {

        for (AEntity entity : entityList) {

            if (entity instanceof ProjectileEntity) {

                ((ProjectileEntity) entity).moveInTravelPath();
            }
        }
    }
}