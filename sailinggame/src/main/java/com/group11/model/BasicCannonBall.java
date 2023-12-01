package com.group11.model;

import com.group11.model.gameentites.AProjectile;

public class BasicCannonBall extends AProjectile {
    public BasicCannonBall() {
        super(0, 30, 10, new int[]{0, 0});
    }

    @Override
    public void concreteTravel() {

        this.move(this.getTruePos().x + this.direction[0], this.getTruePos().y + this.direction[1]);
    }
}