package com.group11.model.gameentites;

public class ProjectileEntity extends AEntity{

    public ProjectileEntity(AProjectile body, String name) {
        super(body, name, true);
    }
    
    public void moveInTravelPath() {
        ((AProjectile) getBody()).moveInTravelPath();
    }

    public boolean isOutOfRange() {
        return ((AProjectile) getBody()).isOutOfRange();
    }

    public int getDamage() {
        return ((AProjectile) getBody()).getDamage();
    }

}   
