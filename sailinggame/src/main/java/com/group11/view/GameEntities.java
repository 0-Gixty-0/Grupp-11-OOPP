package com.group11.view;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The GameEntities class represents the interface and functionality for representing the
 * entities in the world through entity tiles.
 */
public class GameEntities {

    private List<List<Integer>> entityMatrix;
    private List<List<AViewTile>> tileMatrix;;
    private final int tileWidth = 16;
    private final int tileHeight = 16;

    GameEntities(List<List<Integer>> entityMatrix) {
        this.entityMatrix = entityMatrix;
        this.createTileMatrix();
    }

    public List<List<AViewTile>> getTileMatrix() {
        return this.tileMatrix;
    }

    public void updateGameEntities(List<List<Integer>> entityMatrix) {
        this.entityMatrix = entityMatrix;
        this.createTileMatrix();
    }

    /**
     * Initializes construction parameters and creates an EntityTile object.
     * @param id Texture id of entity
     * @param columnIndex The index of which column in a row the tile is to be placed
     * @param rowIndex The index of which row the tile is to be placed
     * @return An EntityTile object representing an entity tile
     */
    private AViewTile initializeEntityTile(int id, int columnIndex, int rowIndex) {
        Dimension dimension = new Dimension(this.tileWidth, this.tileHeight);
        Point matrixPosition = new Point(rowIndex, columnIndex);
        Point pixelPosition = new Point(columnIndex * this.tileWidth, rowIndex * this.tileHeight);
        return new EntityTile(id, dimension, matrixPosition, pixelPosition);
    }

    /**
     * Creates a matrix consisting of EntityTile objects which each represent an entity tile in the world.
     * The size of the matrix is dependent on the number of rows and columns in the attribute terrainMatrix.
     */
    private void createTileMatrix() {
        this.tileMatrix = new ArrayList<>();
        for (int rowIndex = 0; rowIndex < this.entityMatrix.size(); rowIndex++) {
            List<Integer> terrainRow = this.entityMatrix.get(rowIndex);
            ArrayList<AViewTile> tileRow = new ArrayList<>();
            for (int columnIndex = 0; columnIndex < terrainRow.size(); columnIndex++) {
                try {
                    int id = terrainRow.get(columnIndex);
                    tileRow.add(this.initializeEntityTile(id, columnIndex, rowIndex));
                } catch (NullPointerException e) {
                    tileRow.add(null);
                }
            }
            this.tileMatrix.add(tileRow);
        }
    }
}
