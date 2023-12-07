package com.group11.model.gameentites;

import java.awt.Point;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * This abstract class represents a weapon in the game. A weapon is capable of firing projectiles.
 *
 * A weapon has a list of projectiles that it has fired and a maximum number of times it can be fired.
 */
public abstract class AWeapon {

    private List<AProjectile> firedProjectiles;
    private int maxTimesFired;
    private Class<? extends AProjectile> projectileType;

    /**
     * Constructs a new weapon.
     * Initializes the list of fired projectiles.
     */
    protected AWeapon(Class<? extends AProjectile> projectileType, int maxTimesFired) {
        this.projectileType =  projectileType;
        this.firedProjectiles = new ArrayList<>();
        this.maxTimesFired = maxTimesFired;
    }

    /**
     * Returns the type of projectile that this cannon fires.
     * @return the type of projectile that this cannon fires.
     */
    protected Class<? extends AProjectile> getProjectileType() {
        return this.projectileType;
    }

    /**
     * Returns the number of projectiles that this cannon has fired.
     * @return the number of projectiles that this cannon has fired.
     */
    protected int getFiredProjectilesSize() {
        return this.firedProjectiles.size();
    }

    /**
     * Returns the list of projectiles that this cannon has fired.
     * @return the list of projectiles that this cannon has fired.
     */
    public List<AProjectile> getFiredProjectiles() {
        return this.firedProjectiles;
    }

    /**
     * Returns the the max amount of times this cannon can be fired.
     * @return the max amount of times this cannon can be fired.
     */
    protected int getMaxTimesFired() {
        return this.maxTimesFired;
    }

    /**
     * Creates a new instance of the projectile type that this Weapon fires.
     * @param startingPoint the starting point of the projectile
     * @param direction the direction of the projectile
     * @return a new instance of the projectile type that this Weapon fires.
     * @throws RuntimeException if the projectile could not be instantiated
     */
    protected AProjectile createProjectile(Point startingPoint, int [] direction) {
        
        try {
            return this.projectileType.getDeclaredConstructor(Point.class, int[].class).newInstance(startingPoint, direction);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            throw new RuntimeException("Could not instantiate projectile, bad projectile type in weapon");
        }
        
    }

    public void removeOutOfRangeProjectiles() {
        for (int i = 0; i < this.firedProjectiles.size(); i++) {
            if (firedProjectiles.get(i).isOutOfRange()) {
                this.firedProjectiles.remove(i);
            }
        }
    }

    /**
     * Fires the weapon.
     * @param firingPoint the position from which the projectile is fired
     * @param direction the direction in which the projectile is fired
     * @throws RuntimeException if the projectile could not be instantiated
     */
    protected abstract void fireWeapon(Point firingPoint, int [] direction);
}