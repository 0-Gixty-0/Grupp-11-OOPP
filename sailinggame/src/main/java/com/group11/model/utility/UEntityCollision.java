package com.group11.model.utility;

import java.awt.Point;
import java.util.List;

import com.group11.model.gameentites.AEntity;

/**
 * Utility class for checking if an Entity is going to collide with another body.
 */
public final class UEntityCollision {
    
    /**
     * List of Entities to check for collision.
     */
    private static List<List<AEntity>> entities;

    private UEntityCollision() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Set the entities to check for collision.
     * @param bodies Matrix of entities.
     */
    public static void setEntityMatrix(List<List<AEntity>> entities) {
        UEntityCollision.entities = entities;
    }

    private static void checkEntityMatrix() {
        if (entities == null) {
            throw new IllegalStateException("entity matrix not set in UEntityCollision");
        }
    }

    /**
     * Check if a position is occupied by another entity.
     * @param pos Position in the matrix to check.
     * @return (ABody) if the position is occupied by a entity, null otherwise.
     */
    public static AEntity isPositionOccupied(Point pos) {

        checkEntityMatrix();

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
        
        checkEntityMatrix();

        Point bodyPos = entity.getPos();
        int x = (int) bodyPos.getX();
        int y = (int) bodyPos.getY();
        if (entities.get(x).get(y) == entity) {
            return null;
        }
        return entities.get(x).get(y);
    }
}