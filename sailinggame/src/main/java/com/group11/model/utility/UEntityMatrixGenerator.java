package com.group11.model.utility;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import com.group11.model.gameentites.AEntity;

/**
 * UEntityMatrixGenerator has static methods for creating an empty entity matrix and populating with entity objects
 */
public final class UEntityMatrixGenerator {
    /**
     * Utility class does not need to be instantiated
     */
    private UEntityMatrixGenerator() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Creates an entity matrix with all values set to null
     * @param width Number of columns in matrix
     * @param height Number of rows in matrix
     * @return Entity matrix, all values null
     */
    public static List<List<AEntity>> createEntityMatrix(int width, int height) {
        List<List<AEntity>> entityMatrix = new ArrayList<>();
        for (int rowIndex = 0; rowIndex < height; rowIndex++) {
            ArrayList<AEntity> row = new ArrayList<>();
            for (int columnIndex = 0; columnIndex < width; columnIndex++) {
                row.add(null);
            }
            entityMatrix.add(row);
        }
        return entityMatrix;
    }

    /**
     * Adds entities from list to an entity matrix in correct position according to body of entity
     * @param entities List of entities to add to entity matrix
     * @param entityMatrix Entity matrix to add entities to
     * @return Entity matrix with input entities placed in correct position
     */
    public static List<List<AEntity>> populateEntityMatrix(List<AEntity> entities, List<List<AEntity>> entityMatrix) {
        for (AEntity entity : entities) {
            int rowPosition = entity.getBody().getPos().y;
            int columnPosition = entity.getBody().getPos().x;
            List<AEntity> row = entityMatrix.get(rowPosition);
            row.set(columnPosition, entity);
            entityMatrix.set(rowPosition, row);
        }
        return entityMatrix;
    }

    public static void removeEntity(Point position, List<List<AEntity>> entityMatrix) {
        List<AEntity> row = entityMatrix.get(position.x);
        row.set(position.y, null);
        entityMatrix.set(position.x, row);
    }

    public static void addEntity(Point position, AEntity entity, List<List<AEntity>> entityMatrix) {
        List<AEntity> row = entityMatrix.get(position.x);
        row.set(position.y, entity);
        entityMatrix.set(position.x, row);
    }
}
