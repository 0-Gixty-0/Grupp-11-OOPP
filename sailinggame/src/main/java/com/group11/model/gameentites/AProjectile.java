package com.group11.model.gameentites;

import java.awt.*;

public abstract class AProjectile extends AMovableBody{

    protected int distanceTraveled;
    protected int maxRange;
    protected int damage;
    protected int [] direction;

    public AProjectile(int distanceTraveled, int maxRange, int damage, int [] direction){
        super(new Point(0,0), 0, "A projectile");
        this.distanceTraveled = distanceTraveled;
        this.maxRange = maxRange;
        this.damage = damage;
        this.direction = direction;
    }

    public boolean isOutOfRange() {

        if(this.distanceTraveled > this.maxRange) {
            return true;
        }
        return false;
    }

    public int getDistanceTraveled() {
        return this.distanceTraveled;
    }

    public void travel() {

        this.distanceTraveled++;

        continueTravelPath();
    }

    public int[] getDirection() {
        return this.direction;
    }

    public void setDirection(int[] direction) {
        this.direction = direction;
    }

    protected abstract void moveInTravelPath();

    public void continueTravelPath() {
        try {
            moveInTravelPath(); //Checking for out of bounds is done in moveInTravelPath
        } catch (Exception e) {
            return;
        }
    }
}