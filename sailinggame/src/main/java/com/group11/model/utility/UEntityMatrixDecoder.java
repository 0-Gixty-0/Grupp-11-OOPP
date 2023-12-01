package com.group11.model.utility;

import java.util.ArrayList;
import java.util.List;

import com.group11.model.gameentites.AEntity;

/**
 * Utility class for converting a 2D matrix of AEntity objects into a 2D matrix of integers.
 * Each AEntity object is replaced by an integer ID, which is the index of the entity's name in a predefined list.
 * Null entities are represented by -1.
 */
public final class UEntityMatrixDecoder {
    /**
     * List of entity names. The index of each name serves as the corresponding integer ID for that entity.
     */
    private static List<String> entityNames = new ArrayList<>(); 
        static {
        entityNames.add("Player");
        entityNames.add("Enemy: lvl 1");
        entityNames.add("Enemy: lvl 2");
        // Add more entity names as needed
    }

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private UEntityMatrixDecoder() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Returns the integer ID corresponding to the given entity.
     * The ID is the index of the entity's name in entityNames.
     * @param entity the entity whose ID is to be retrieved
     * @return the integer ID of the entity
     * @throws IllegalArgumentException if the entity's name is not found in entityNames
     */
    private static int getEntityId(AEntity entity) {
        String entityName = entity.getName();
        int entityId = entityNames.indexOf(entityName);
        if (entityId == -1) throw new IllegalArgumentException("Entity name not found in entityNames");
        return entityId;
    }

    /**
     * Converts a 2D matrix of AEntity objects into a 2D matrix of integers.
     * Each AEntity object is replaced by its corresponding integer ID, as determined by the getEntityId method.
     * Null entities are represented by -1.
     * @param matrix the 2D matrix of AEntity objects to be converted
     * @return the converted 2D matrix of integers
     */
    public static List<List<Integer>> decodeIntoIntMatrix(List<List<AEntity>> matrix) {
        List<List<Integer>> intMatrix = new ArrayList<>();
        for (List<AEntity> row : matrix) {
            List<Integer> intRow = new ArrayList<>();
            for (AEntity entity : row) {
                intRow.add(entity == null ? -1 : getEntityId(entity));
            }
            intMatrix.add(intRow);
        }
        return intMatrix;
    }
}
