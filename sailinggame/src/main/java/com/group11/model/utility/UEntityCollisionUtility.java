package com.group11.model.utility;

import java.awt.Point;
import java.util.List;

import com.group11.model.gameentites.AEntity;

/**
 * Utility class for checking if an Entity is going to collide with another body.
 */
public final class UEntityCollisionUtility {
    
    /**
     * List of Entities to check for collision.
     */
    private static List<List<AEntity>> entities;

    private UEntityCollisionUtility() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Set the entities to check for collision.
     * @param bodies Matrix of entities.
     */
    public static void setBodyMatrix(List<List<AEntity>> entities) {
        UEntityCollisionUtility.entities = entities;
    }

    private static void checkBodies() {
        if (entities == null) {
            throw new IllegalStateException("Bodies not set in BodyCollisionUtility");
        }
    }

    /**
     * Check if a position is occupied by another entity.
     * @param pos Position in the matrix to check.
     * @return (ABody) if the position is occupied by a entity, null otherwise.
     */
    public static AEntity isPositionOccupied(Point pos) {

        checkBodies();

        int x = (int) pos.getX();
        int y = (int) pos.getY();

        return entities.get(x).get(y);
    }

    /**
     * Check if a entity is colliding with another entity.
     * @param body Entity to check.
     * @return (ABody) if the position is occupied by a entity, null otherwise.
     */
    public static AEntity isEntityColliding(AEntity entity) {
        
        checkBodies();

        Point bodyPos = entity.getPos();
        int x = (int) bodyPos.getX();
        int y = (int) bodyPos.getY();

        return entities.get(x).get(y);
    }
}