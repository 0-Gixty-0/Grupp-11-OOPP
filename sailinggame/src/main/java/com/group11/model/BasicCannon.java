package com.group11.model;

public class BasicCannon implements IWeapon{
    AProjectile projectile;

    public BasicCannon(){
        this.projectile = new BasicCannonBall();
    }

    public void setWeapon() {
        // TODO make this method
    }
}