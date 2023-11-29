package com.group11.model;

import java.util.ArrayList;

public final class UEntityMatrixGenerator {
    private UEntityMatrixGenerator() {System.out.println("Utility class cannot be instantiated");}

    public static ArrayList<ArrayList<AEntity>> createEntityMatrix(int width, int height) {
        ArrayList<ArrayList<AEntity>> entityMatrix = new ArrayList<>();
        for (int rowIndex = 0; rowIndex < height; rowIndex++) {
            ArrayList<AEntity> row = new ArrayList<>();
            for (int columnIndex = 0; columnIndex < width; columnIndex++) {
                row.add(null);
            }
            entityMatrix.add(row);
        }
        return entityMatrix;
    }

    public static ArrayList<ArrayList<AEntity>> populateEntityMatrix(ArrayList<AEntity> entities, ArrayList<ArrayList<AEntity>> entityMatrix) {
        for (AEntity entity : entities) {
            int rowPosition = entity.getBody().getPos().y;
            int columnPosition = entity.getBody().getPos().x;
            ArrayList<AEntity> row = entityMatrix.get(rowPosition);
            row.set(columnPosition, entity);
            entityMatrix.set(rowPosition, row);
        }
        return entityMatrix;
    }
}
