package com.group11.model.utility;

import java.util.ArrayList;
import java.util.List;

import com.group11.model.gameentites.AEntity;
import com.group11.model.gameentites.AWeapon;
import com.group11.model.gameentites.CommandableEntity;
import com.group11.model.gameentites.ProjectileEntity;

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
    public static void checkProjectileCollisions(List<AEntity> entityList) {

        for (AEntity entity : entityList) {

            AEntity collidingEntity = UEntityCollisionUtility.isEntityColliding(entity);

            if (collidingEntity instanceof ProjectileEntity)  {

                entity.takeDamage(((ProjectileEntity) collidingEntity).getDamage());

            }
        }
    }

    /**
     * Updates the projectile entities in the entity list, removing out of range projectiles and adding new ones.
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
