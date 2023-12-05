package com.group11.model.utility;

import java.awt.Point;
import java.util.List;

import com.group11.model.gameentites.AEntity;

/**
 * Utility class for checking if a body is going to collide with another body.
 */
public final class UBodyCollisionUtility {
    
    /**
     * List of bodies to check for collision.
     */
    private static List<List<AEntity>> entities;

    private UBodyCollisionUtility() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Set the bodies to check for collision.
     * @param bodies Matrix of bodies.
     */
    public static void setBodyMatrix(List<List<AEntity>> entities) {
        UBodyCollisionUtility.entities = entities;
    }

    private static void checkBodies() {
        if (entities == null) {
            throw new IllegalStateException("Bodies not set in BodyCollisionUtility");
        }
    }

    /**
     * Check if a position is occupied by another body.
     * @param pos Position in the matrix to check.
     * @return (ABody) if the position is occupied by a body, null otherwise.
     */
    public static AEntity isPositionOccupied(Point pos) {

        checkBodies();

        int x = (int) pos.getX();
        int y = (int) pos.getY();

        return entities.get(x).get(y);
    }

    /**
     * Check if a body is colliding with another body.
     * @param body Body to check.
     * @return (ABody) if the position is occupied by a body, null otherwise.
     */
    public static AEntity isEntityColliding(AEntity entity) {
        
        checkBodies();

        Point bodyPos = entity.getPos();
        int x = (int) bodyPos.getX();
        int y = (int) bodyPos.getY();

        return entities.get(x).get(y);
    }
}