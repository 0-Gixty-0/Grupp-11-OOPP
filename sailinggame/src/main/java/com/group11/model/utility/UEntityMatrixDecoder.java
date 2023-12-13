package com.group11.model.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

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
    private static final HashMap<String, Integer> entityIds = new HashMap<>();
    static {
        entityIds.put("Player", 0);
        entityIds.put("Enemy", 1);
        entityIds.put("CannonBall", 2);
        // Add more entities as needed
    }

    private static List<List<AEntity>> entityMatrix;

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
        Integer entityId = null;
    
        for (Entry<String, Integer> entry : entityIds.entrySet()) {
            if (entityName.contains(entry.getKey())) {
                entityId = entry.getValue();
                break;
            }
        }
    
        if (entityId == null) {
            throw new IllegalArgumentException("Entity name not found: " + entityName);
        }
    
        return entityId;
    }


    public static void setEntityMatrix(List<List<AEntity>> entityMatrix) {
        UEntityMatrixDecoder.entityMatrix = entityMatrix;
    }

    /**
     * Converts a 2D matrix of AEntity objects into a 2D matrix of integers.
     * Each AEntity object is replaced by its corresponding integer ID, as determined by the getEntityId method.
     * Null entities are represented by -1.
     * @param matrix the 2D matrix of AEntity objects to be converted
     * @return the converted 2D matrix of integers
     */
    public static List<List<Integer>> decodeIntoIntMatrix() {
        List<List<Integer>> intMatrix = new ArrayList<>();
        for (List<AEntity> row : entityMatrix) {
            List<Integer> intRow = new ArrayList<>();
            for (AEntity entity : row) {
                intRow.add(entity == null ? -1 : getEntityId(entity));
            }
            intMatrix.add(intRow);
        }
        return intMatrix;
    }
}
