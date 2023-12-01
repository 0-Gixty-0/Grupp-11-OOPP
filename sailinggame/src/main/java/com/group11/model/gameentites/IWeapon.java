package com.group11.model.gameentites;

import java.util.List;

public abstract class IWeapon {

    List<AProjectile> firedProjectiles;
    int maxTimesFired;
    public abstract void fireWeapon();
}
