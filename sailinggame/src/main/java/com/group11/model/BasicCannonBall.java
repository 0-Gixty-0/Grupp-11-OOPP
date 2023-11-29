package com.group11.model;

public class BasicCannonBall extends AProjectile {
    BasicCannonBall() {
        super(0, 30, 10, new int[]{0, 0});
    }

    public void travel() {

        if(isOutOfRange(this)){
            // Delete instance
        }


        this.distanceTraveled++;

        this.move(this.getTruePos().x + this.direction[0], this.getTruePos().y + this.direction[1]);
    }
}