package com.group11.model.gameentites;

/**
 * This class represents a ZigZagCannonBall in the game. A ZigZagCannonBall is a type of projectile that can be fired by a weapon.
 *
 * A ZigZagCannonBall has a distance it has traveled, a maximum range it can travel, the damage it can cause,
 * the direction it is traveling in, and the hitpoints it has. A ZigZagCannonBall always has 1 hitpoint.
 *
 * The ZigZagCannonBall has a unique movement pattern where it moves in a zigzag path.
 */
public class ZigZagCannonBall extends AProjectile {

    /**
     * Constructs a new ZigZagCannonBall with the given parameters.
     *
     * The distance traveled is initialized to 0, the maximum range is 50, the damage is 50, the direction is {0, 0}, and the hitpoints is 1.
     */
    ZigZagCannonBall() {
        super(0, 50, 50, new int[]{0, 0}, 1);
    }

    /**
     * Moves the ZigZagCannonBall along its zigzag travel path if possible.
     *
     * The direction of the movement is determined by the current direction of the ZigZagCannonBall.
     */
    @Override
    protected void moveInTravelPath() {

    }
}