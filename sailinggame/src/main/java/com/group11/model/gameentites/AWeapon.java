package com.group11.model.gameentites;

import java.util.ArrayList;
import java.util.List;

/**
 * This abstract class represents a weapon in the game. A weapon is capable of firing projectiles.
 *
 * A weapon has a list of projectiles that it has fired and a maximum number of times it can be fired.
 */
public abstract class AWeapon {

    protected List<AProjectile> firedProjectiles;
    protected int maxTimesFired;

    /**
     * Constructs a new weapon.
     *
     * Initializes the list of fired projectiles.
     */
    protected AWeapon() {
        this.firedProjectiles = new ArrayList<AProjectile>();
    }

    /**
     * Fires the weapon.
     *
     * This method must be implemented by subclasses.
     */
    public abstract void fireWeapon();
}