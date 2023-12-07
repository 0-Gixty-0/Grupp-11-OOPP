package com.group11.model.gameentites;

import java.awt.Point;

/**
 * This class represents the weapon "BasicCannon" in the game. A BasicCannon is a type of weapon that fires projectiles.
 * A BasicCannon has a specific type of projectile that it fires, and a maximum number of times it can be fired.
 */
public class BasicCannon extends AWeapon {

    /**
     * Constructs a new basic cannon with the given projectile type.
     * @param projectileType the type of projectile that this cannon fires
     */
    public BasicCannon(Class<? extends AProjectile> projectileType){
        super(projectileType, 5);
    }

    /**
     * Fires a single projectile, adding a new instance of the projectile type to the list of fired projectiles.
     * @throws RuntimeException if the projectile could not be instantiated
     */
    @Override
    public void fireWeapon(Point firingPoint, int [] direction) {
        if (this.getFiredProjectilesSize() < this.getMaxTimesFired()) {
            this.getFiredProjectiles().add(this.createProjectile(firingPoint, direction));
        }
    }

}