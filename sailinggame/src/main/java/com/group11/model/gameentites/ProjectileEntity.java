package com.group11.model.gameentites;

/**
 * This class represents a projectile entity in the game. A projectile entity is a type of entity that is created when a weapon is fired.
 * A projectile entity has a body, which is an instance of AProjectile, and a name.
 * The body of a projectile entity can move along a travel path, check if it is out of range, and get the damage it can cause.
 */
public class ProjectileEntity extends AEntity{

    /**
     * Constructs a new projectile entity with the given body and name.
     * The body of a projectile entity is an instance of AProjectile.
     * The name of a projectile entity is a string.
     *
     * @param body The body of the projectile entity.
     * @param name The name of the projectile entity.
     */
    public ProjectileEntity(AProjectile body, String name) {
        super(body, name, true);
    }

    /**
     * Moves the body of the projectile entity along its travel path.
     */
    public void moveInTravelPath() {
        ((AProjectile) getBody()).moveInTravelPath();
    }

    /**
     * Checks if the body of the projectile entity is out of range.
     *
     * @return True if the body of the projectile entity is out of range, false otherwise.
     */
    public boolean isOutOfRange() {
        return ((AProjectile) getBody()).isOutOfRange();
    }

    /**
     * Returns the damage that the body of the projectile entity can cause.
     *
     * @return The damage that the body of the projectile entity can cause.
     */
    public int getDamage() {
        return ((AProjectile) getBody()).getDamage();
    }
}