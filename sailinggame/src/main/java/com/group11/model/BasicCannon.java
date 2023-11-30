package com.group11.model;

public class BasicCannon implements IWeapon{
    AProjectile projectile;

    public BasicCannon(AProjectile projectileType){
        this.projectile = projectileType;
    }

    public Object getProjectileType() {
        return this.projectile;
    }

    public void setWeapon() {
        // TODO make this method
    }
}