package com.group11.model.gameentites;

import java.awt.Point;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * This abstract class represents a weapon in the game. A weapon is capable of firing projectiles.
 * A weapon has a list of projectiles that it has fired and a maximum number of times it can be fired.
 * Intended to be used by ships and other subclasses of body.
 */
public abstract class AWeapon {

    private List<ProjectileEntity> firedProjectiles;
    private int maxTimesFired;
    private Class<? extends AProjectile> projectileType;

    /**
     * Constructs a new weapon.
     * Initializes the list of fired projectiles.
     *
     * @param projectileType The type of projectile that this weapon fires.
     * @param maxTimesFired The maximum number of times this weapon can be fired.
     */
    protected AWeapon(Class<? extends AProjectile> projectileType, int maxTimesFired) {
        this.projectileType =  projectileType;
        this.firedProjectiles = new ArrayList<>();
        this.maxTimesFired = maxTimesFired;
    }

    /**
     * Returns the type of projectile that this cannon fires.
     *
     * @return the type of projectile that this cannon fires.
     */
    public Class<? extends AProjectile> getProjectileType() {
        return this.projectileType;
    }

    /**
     * Returns the number of projectiles that this cannon has fired.
     *
     * @return the number of projectiles that this cannon has fired.
     */
    protected int getFiredProjectilesSize() {
        return this.firedProjectiles.size();
    }

    /**
     * Returns the list of projectiles that this cannon has fired.
     *
     * @return the list of projectiles that this cannon has fired.
     */
    protected List<ProjectileEntity> getFiredProjectiles() {
        return this.firedProjectiles;
    }

    /**
     * Returns the max amount of times this cannon can be fired.
     *
     * @return the max amount of times this cannon can be fired.
     */
    protected int getMaxTimesFired() {
        return this.maxTimesFired;
    }

    /**
     * Creates a new instance of the projectile type that this Weapon fires.
     *
     * @param startingPoint the starting point of the projectile
     * @param direction the direction of the projectile
     * @return a new instance of the projectile type that this Weapon fires.
     * @throws RuntimeException if the projectile could not be instantiated
     */
    protected ProjectileEntity createProjectile(Point startingPoint, int [] direction) {
        try {
            AProjectile projectile = this.projectileType.getDeclaredConstructor(Point.class, int[].class).newInstance(startingPoint, direction);
            return new ProjectileEntity(projectile, projectile.getProjectileName());
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            throw new IllegalStateException("Could not instantiate projectile, bad projectile type in weapon");
        }
        
    }

    /**
     * Removes projectiles that are out of range from the list of fired projectiles.
     */
    public void removeOutOfRangeProjectiles() {
        firedProjectiles.removeIf(e -> e.isOutOfRange());
    }

    /**
     * Removes projectiles with <= 0 hp from the list of fired projectiles.
     */
    public void removeDeadProjectiles() {
        firedProjectiles.removeIf(e -> e.getHitPoints() <= 0);
    }

    /**
     * Fires the weapon.
     *
     * @param firingPoint the position from which the projectile is fired
     * @param direction the direction in which the projectile is fired
     * @throws RuntimeException if the projectile could not be instantiated
     */
    public abstract void fireWeapon(Point firingPoint, int [] direction);
}