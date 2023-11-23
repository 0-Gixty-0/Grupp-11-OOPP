package com.group11.view;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public abstract class AViewUtility {
    
    private final int tileWidth = 16;
    private final int tileHeight = 16;
    private List<List<AViewTile>> tileMatrix;
    
    protected void updateTileMatrix(List<List<Integer>> terrainMatrix) {
        tileMatrix = createTileMatrix(terrainMatrix);
    }

    protected List<List<AViewTile>> getTileMatrix() {
        return tileMatrix;
    }

    protected abstract AViewTile tileType(int id, Dimension dimension, Point matrixPosition, Point pixelPosition);

    /**
     * Helper function for initializing an object of type ViewTile
     * @param id The id of the terrain type
     * @param columnIndex The index of which spot in the row the tile is to be placed
     * @param rowIndex The index of which row the tile is to be placed in
     * @return A TerrainTile object representing a terrain tile
     */
    private AViewTile initializeTile(int id, int columnIndex, int rowIndex) {
        Dimension dimension = new Dimension(tileWidth, tileHeight);
        Point matrixPosition = new Point(rowIndex, columnIndex);
        Point pixelPosition = new Point(columnIndex * tileWidth, rowIndex * tileHeight);
        return tileType(id, dimension, matrixPosition, pixelPosition);
    }
    

    private List<List<AViewTile>> createTileMatrix(List<List<Integer>> terrainMatrix) {

        List<List<AViewTile>> tileMatrix = new ArrayList<>();

        for (int rowIndex = 0; rowIndex < terrainMatrix.size(); rowIndex++) {

            List<Integer> terrainRow = terrainMatrix.get(rowIndex);

            List<AViewTile> tileRow = new ArrayList<>();

            for (int columnIndex = 0; columnIndex < terrainRow.size(); columnIndex++) {
                try {
                    int id = terrainRow.get(columnIndex);
                    tileRow.add(initializeTile(id, columnIndex, rowIndex));
                } catch (NullPointerException e) {
                    tileRow.add(null);
                }
            }
            
            tileMatrix.add(tileRow);
        }
        
        return tileMatrix;
    }   


}
