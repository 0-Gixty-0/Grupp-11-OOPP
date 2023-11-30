package com.group11.view;

import java.util.ArrayList;
import java.util.List;

import com.group11.view.uicomponents.AViewDrawable;

/**
 * A static utility class that creates a matrix of ViewTiles from a matrix of integers. 
 * In other words this class encodes a universal language into a domain (View) specific language.
 */
public class ViewTileMatrixEncoder {
    
    private static AViewDrawableFactory entityTileFactory = new EntityTileFactory();
    private static AViewDrawableFactory terrainTileFactory = new TerrainTileFactory();

    private ViewTileMatrixEncoder() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Create a matrix of ViewTiles representing entities from a matrix of integers.
     * @param intMatrix The matrix of integers.
     * @return The matrix of ViewTiles.
     */
    public static List<List<AViewDrawable>> createEntityTileMatrix(List<List<Integer>> intMatrix) {
        return createTileMatrix(intMatrix, 1); 
    }

    /**
     * Create a matrix of ViewTiles representing terrain from a matrix of integers.
     * @param intMatrix The matrix of integers.
     * @return The matrix of ViewTiles.
     */
    public static List<List<AViewDrawable>> createTerrainTileMatrix(List<List<Integer>> intMatrix) {
        return createTileMatrix(intMatrix, 0);
    }

    /**
     * Add an entity AViewDrawable to a row of AViewDrawables.
     * @param rowIndex The index of the row.
     * @param intRow The row of integers.
     * @param tileRow The row of ViewTiles.
     * @param columnIndex The index of the column.
     */
    private static void addEntityTile(List<Integer> intRow, List<AViewDrawable> tileRow, int columnIndex) {
        int id = intRow.get(columnIndex);
        tileRow.add(entityTileFactory.createDrawable(id));
    }

    /**
     * Add a terrain AViewDrawable to a row of ViewDrawables.
     * @param rowIndex The index of the row.
     * @param intRow The row of integers.
     * @param tileRow The row of ViewTiles.
     * @param columnIndex The index of the column.
     */
    private static void addTerrainTile(List<Integer> intRow, List<AViewDrawable> tileRow, int columnIndex) {
        int id = intRow.get(columnIndex);
        tileRow.add(terrainTileFactory.createDrawable(id));
    }

    /**
     * Extracted function for creating a matrix of ViewTiles from a matrix of integers.
     * @param intMatrix The matrix of integers.
     * @param terrainOrEntity 0 for terrain, 1 for entity.
     * @return The matrix of ViewTiles.
     */
    private static List<List<AViewDrawable>> createTileMatrix(List<List<Integer>> intMatrix, int terrainOrEntity) {

        List<List<AViewDrawable>> tileMatrix = new ArrayList<>();

        for (int rowIndex = 0; rowIndex < intMatrix.size(); rowIndex++) {

            List<Integer> intRow = intMatrix.get(rowIndex);

            List<AViewDrawable> tileRow = new ArrayList<>();

            for (int columnIndex = 0; columnIndex < intRow.size(); columnIndex++) {
                
                if (terrainOrEntity == 0) {
                    addTerrainTile(intRow, tileRow, columnIndex);
                } else if (terrainOrEntity == 1) {
                    addEntityTile(intRow, tileRow, columnIndex);
                }
                
            }
            
            tileMatrix.add(tileRow);
        }
        
        return tileMatrix;
    }
}
