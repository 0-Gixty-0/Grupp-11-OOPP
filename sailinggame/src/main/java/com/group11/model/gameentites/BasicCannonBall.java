package com.group11.model.gameentites;

public class BasicCannonBall extends AProjectile {
    public BasicCannonBall() {
        super(0, 30, 10, new int[]{0, 0});
    }

    @Override
    public void moveInTravelPath() {
        this.moveIfPossible(this.direction);
    }
}