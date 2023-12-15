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
     * Creates a 2D matrix of AEntity objects with the specified width and height, and populates it with the entities from the provided list.
     * The position of each entity in the matrix corresponds to its position in the game world.
     * The most recently created matrix is stored as an instance variable and can be updated by calling updateEntityMatrix.
     *
     * @param width the number of columns in the matrix
     * @param height the number of rows in the matrix
     * @param entityList the list of entities to be added to the matrix
     * @return the populated matrix of AEntity objects
     * @throws IllegalArgumentException if an entity's position is out of bounds for the matrix dimensions
     */
    public static List<List<AEntity>> createEntityMatrix(int width, int height, List<AEntity> entityList) {

        // Check that entity positions are within the bounds of entity matrix.
        // Adding entities to occupiedPositions list to easier update.
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
     * Updates the most recently created matrix with the entities from the provided list.
     * The position of each entity in the matrix corresponds to its position in the game world.
     * The list of occupied positions is updated accordingly.
     *
     * @param entityList the list of entities to be added to the matrix
     * @throws IllegalStateException if createEntityMatrix has not been called before this method
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
     *
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

    /**
     * Updates the list of occupied positions with the positions of the entities from the provided list.
     *
     * @param entities the list of entities whose positions are to be added to the list of occupied positions
     */
    private static void updateOccupiedPositions(List<AEntity> entities) {
        occupiedPositions.clear();
        for (AEntity entity : entities) {
            occupiedPositions.add(entity.getPos());
        }
    }
}