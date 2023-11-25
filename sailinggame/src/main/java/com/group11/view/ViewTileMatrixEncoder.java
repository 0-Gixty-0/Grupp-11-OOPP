package com.group11.view;

import java.util.ArrayList;
import java.util.List;

/**
 * A static utility class that creates a matrix of ViewTiles from a matrix of integers. 
 * In other words this class encodes a universal language into a domain (View) specific language.
 */
public class ViewTileMatrixEncoder {
    
    private static AViewTileFactory entityTileFactory = new EntityTileFactory();
    private static AViewTileFactory terrainTileFactory = new TerrainTileFactory();

    private ViewTileMatrixEncoder() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Create a matrix of ViewTiles representing entities from a matrix of integers.
     * @param intMatrix The matrix of integers.
     * @return The matrix of ViewTiles.
     */
    public static List<List<ViewTile>> createEntityTileMatrix(List<List<Integer>> intMatrix) {
        return createTileMatrix(intMatrix, 1); 
    }

    /**
     * Create a matrix of ViewTiles representing terrain from a matrix of integers.
     * @param intMatrix The matrix of integers.
     * @return The matrix of ViewTiles.
     */
    public static List<List<ViewTile>> createTerrainTileMatrix(List<List<Integer>> intMatrix) {
        return createTileMatrix(intMatrix, 0);
    }

    /**
     * Add a entity ViewTile to a row of ViewTiles.
     * @param rowIndex The index of the row.
     * @param intRow The row of integers.
     * @param tileRow The row of ViewTiles.
     * @param columnIndex The index of the column.
     */
    private static void addEntityTile(List<Integer> intRow, List<ViewTile> tileRow, int columnIndex) {
        int id = intRow.get(columnIndex);
        tileRow.add(entityTileFactory.createTile(id));
    }

    /**
     * Add a terrain ViewTile to a row of ViewTiles.
     * @param rowIndex The index of the row.
     * @param intRow The row of integers.
     * @param tileRow The row of ViewTiles.
     * @param columnIndex The index of the column.
     */
    private static void addTerrainTile(List<Integer> intRow, List<ViewTile> tileRow, int columnIndex) {
        int id = intRow.get(columnIndex);
        tileRow.add(terrainTileFactory.createTile(id));
    }

    /**
     * Extracted function for creating a matrix of ViewTiles from a matrix of integers.
     * @param intMatrix The matrix of integers.
     * @param terrainOrEntity 0 for terrain, 1 for entity.
     * @return The matrix of ViewTiles.
     */
    private static List<List<ViewTile>> createTileMatrix(List<List<Integer>> intMatrix, int terrainOrEntity) {

        List<List<ViewTile>> tileMatrix = new ArrayList<>();

        for (int rowIndex = 0; rowIndex < intMatrix.size(); rowIndex++) {

            List<Integer> intRow = intMatrix.get(rowIndex);

            List<ViewTile> tileRow = new ArrayList<>();

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
