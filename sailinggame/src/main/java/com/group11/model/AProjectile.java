package com.group11.model;

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

    public abstract void travel();
}