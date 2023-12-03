package com.group11.model.gameentites;
import java.lang.reflect.InvocationTargetException;

/**
 * This class represents the weapon "BasicCannon" in the game. A BasicCannon is a type of weapon that fires projectiles.
 *
 * A BasicCannon has a specific type of projectile that it fires, and a maximum number of times it can be fired.
 *
 * @param <T> the type of projectile that the cannon fires
 */
public class BasicCannon<T> extends AWeapon {
    private final T projectileType;

    /**
     * Constructs a new basic cannon with the given projectile type.
     *
     * @param projectileType the type of projectile that this cannon fires
     * @throws IllegalArgumentException if the projectileType is not of type AProjectile
     */
    public BasicCannon(T projectileType){
        if (projectileType instanceof AProjectile) {
            this.projectileType = projectileType;
        } else {
            throw new IllegalArgumentException("projectileType must be of type AProjectile");
        }
        this.maxTimesFired = 5;
    }

    /**
     * Returns the type of projectile that this cannon fires.
     *
     * @return the type of projectile that this cannon fires
     */
    public T getProjectileType() {
        return this.projectileType;
    }

    /**
     * Returns the number of projectiles that this cannon has fired.
     *
     * @return the number of projectiles that this cannon has fired
     */
    public int getFiredProjectilesSize() {
        return this.firedProjectiles.size();
    }

    /**
     * Fires the weapon, adding a new instance of the projectile type to the list of fired projectiles.
     *
     * @throws RuntimeException if the projectile could not be instantiated
     */
    @Override
    public void fireWeapon() {
        if (this.firedProjectiles.size() < this.maxTimesFired) {
            try {
                this.firedProjectiles.add((AProjectile) this.projectileType.getClass().getConstructor().newInstance());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                throw new RuntimeException("Could not instantiate projectile because of: " + e.getMessage());
            }
        }
    }
}