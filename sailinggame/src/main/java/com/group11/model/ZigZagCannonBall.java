package com.group11.model;


import com.group11.model.gameentites.AProjectile;

public class ZigZagCannonBall extends AProjectile {
    ZigZagCannonBall() {
        super(0, 50, 50, new int[]{0, 0});
    }

    public void concreteTravel() {
        // Specific code for making the ball travel zigzag
    }
}