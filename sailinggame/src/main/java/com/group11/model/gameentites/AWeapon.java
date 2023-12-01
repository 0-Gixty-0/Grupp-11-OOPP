package com.group11.model.gameentites;

import java.util.List;

public abstract class AWeapon {

    List<AProjectile> firedProjectiles;
    int maxTimesFired;
    public abstract void fireWeapon();
}