package com.group11.model.utility;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import com.group11.model.gameentites.AEntity;

/**
 * UEntityMatrixGenerator has static methods for creating an empty entity matrix and populating with entity objects
 */
public final class UEntityMatrixGenerator {

    private static List<Point> occupiedPositions = new ArrayList<>();
    private static List<List<AEntity>> entityMatrixInstance;

    /**
     * Utility class does not need to be instantiated
     */
    private UEntityMatrixGenerator() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Creates the entity matrix populated with entities. There can only exist on instance of EntityMatrix at a time.
     * if this method is called more than once, the first instance will be returned.
     * @param width Number of columns in matrix.
     * @param height Number of rows in matrix.
     * @param entityList List of entities to add to matrix.
     * @return Populated entity matrix.
     */
    public static List<List<AEntity>> createEntityMatrix(int width, int height, List<AEntity> entityList) {

        // There should only be one entity matrix instance at a time to not break the system with.
        // occupied positions and entity matrix not being in sync.
        if (entityMatrixInstance != null) {
            return entityMatrixInstance;
        }

        // Check that entity positions are within bounds of entity matrix.
        // adding entities to occupiedPositions list to easier update.
        for (AEntity entity : entityList) {
            if (entity.getPos().x >= height || entity.getPos().y >= width) {
                throw new IllegalArgumentException("Entity position out of bounds for entityMatrix dimensions");
            }
        }

        updateOccupiedPositions(entityList);

        List<List<AEntity>> entityMatrix = new ArrayList<>();

        for (int rowIndex = 0; rowIndex < height; rowIndex++) {
            List<AEntity> row = new ArrayList<>();
            for (int columnIndex = 0; columnIndex < width; columnIndex++) {
                row.add(null);
            }
            entityMatrix.add(row);
        }
        
        addEntitiesToMatrix(entityMatrix, entityList);

        entityMatrixInstance = entityMatrix;

        return entityMatrix;
    }

    /**
     * Updates the entity matrix instance with new entities
     * @param entityList The list of entities to update the entity matrix with
     */
    public static void updateEntityMatrix(List<AEntity> entityList) {
        
        if (occupiedPositions == null) {
            throw new IllegalStateException("Call createEntityMatrix before trying to update one");
        }

        // Clear formerly occupied positions
        for (int i = 0; i < occupiedPositions.size(); i++) {
            entityMatrixInstance.get(occupiedPositions.get(i).x).set(occupiedPositions.get(i).y, null);
        }

        // Add new occupied positions
        updateOccupiedPositions(entityList);

        addEntitiesToMatrix(entityMatrixInstance, entityList);
    }

    /**
     * Adds entities to the entity matrix
     * @param entityMatrix The entity matrix to add entities to
     * @param entities The entities to add to the entity matrix
     */
    private static void addEntitiesToMatrix(List<List<AEntity>> entityMatrix, List<AEntity> entities) {
        for (AEntity entity : entities) {
            int entityX = entity.getPos().x;
            int entityY = entity.getPos().y;
            entityMatrix.get(entityX).set(entityY, entity);
        }
    }

    private static void updateOccupiedPositions(List<AEntity> entities) {
        occupiedPositions.clear();
        for (AEntity entity : entities) {
            occupiedPositions.add(entity.getPos());
        }
    }
}
