package com.group11.model.gameentites;

import java.util.ArrayList;
import java.util.List;

public abstract class AWeapon {

    List<AProjectile> firedProjectiles;
    int maxTimesFired;
    protected AWeapon() {
        this.firedProjectiles = new ArrayList<AProjectile>();
    }

    public abstract void fireWeapon();
}