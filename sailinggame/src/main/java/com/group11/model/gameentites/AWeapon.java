package com.group11.model.gameentites;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * This abstract class represents a weapon in the game. A weapon is capable of firing projectiles.
 *
 * A weapon has a list of projectiles that it has fired and a maximum number of times it can be fired.
 */
public abstract class AWeapon<T> {

    private List<AProjectile> firedProjectiles;
    private int maxTimesFired;
    private T projectileType;

    /**
     * Constructs a new weapon.
     * Initializes the list of fired projectiles.
     */
    protected AWeapon(T projectileType, int maxTimesFired) {
        if (!(projectileType instanceof AProjectile)) {
            throw new IllegalArgumentException("projectileType must be of type AProjectile");
        }
        this.projectileType = projectileType;
        this.firedProjectiles = new ArrayList<>();
        this.maxTimesFired = maxTimesFired;
    }

    /**
     * Returns the type of projectile that this cannon fires.
     * @return the type of projectile that this cannon fires.
     */
    protected T getProjectileType() {
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
    protected List<AProjectile> getFiredProjectiles() {
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
     * @return a new instance of the projectile type that this Weapon fires.
     * @throws RuntimeException if the projectile could not be instantiated
     */
    protected AProjectile createProjectile(int [] direction) {
        try {
            return (AProjectile) this.projectileType.getClass().getDeclaredConstructor(int[].class).newInstance(direction);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new IllegalStateException("Could not instantiate projectile", e);
        }
    }

    /**
     * Fires the weapon.
     * @throws RuntimeException if the projectile could not be instantiated
     */
    public abstract void fireWeapon(int [] direction);
}