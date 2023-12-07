package com.group11.model.factories;

import java.awt.Point;

import com.group11.model.gameentites.AProjectile;
import com.group11.model.gameentites.BasicCannonBall;

public class ProjectileFactory {
    /**
     * Creates a new BasicCannonBall with the given parameters.
     * @param pos the starting position of the projectile
     * @param direction the direction the projectile is traveling in
     * @return a new BasicCannonBall instance
     */
    public static AProjectile createBasicCannonBall(Point pos, int[] direction) {
        return new BasicCannonBall(pos, direction);
    }

}
