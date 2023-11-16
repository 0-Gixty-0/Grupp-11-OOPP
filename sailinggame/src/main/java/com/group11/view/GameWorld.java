package com.group11.view;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The GameWorld class represents the functionality and interface for represent the
 * terrain aspects of the game world such as tiles.
 */
public class GameWorld {
    private List<List<Integer>> terrainMatrix;
    private ArrayList<ArrayList<AViewTile>> tileMatrix = new ArrayList<>();
    private final int tileWidth = 16;
    private final int tileHeight = 16;
    private int windowWidth;
    private int windowHeight;

    /**
     * GameWorld constructor sets attributes and creates tile components.
     * @param matrix A matrix consisting of tileset id:s
     * @param width  The width of the window frame
     * @param height The height of the window frame
     */
    GameWorld(List<List<Integer>> matrix, int width, int height) {
        this.terrainMatrix = matrix;
        this.windowHeight = height;
        this.windowWidth = width;
        this.createTileMatrix();
    }

    /**
     * Returns a matrix of ViewTile objects
     * @return A matrix of ViewTile objects
     */
    public ArrayList<ArrayList<AViewTile>> getTileMatrix() {
        return tileMatrix;
    }


    /**
     * Helper function for initializing an object of type ViewTile
     * @param id The id of the terrain type
     * @param columnIndex The index of which spot in the row the tile is to be placed
     * @param rowIndex The index of which row the tile is to be placed in
     * @return A JLabel representing a tile which consists of size and location.
     */
    private AViewTile initializeTerrainTile(int id, int columnIndex, int rowIndex) {
        Dimension dimension = new Dimension(this.tileWidth, this.tileHeight);
        Point matrixPosition = new Point(rowIndex, columnIndex);
        Point pixelPosition = new Point(columnIndex * this.tileWidth, rowIndex * this.tileHeight);
        return new TerrainTile(id, dimension, matrixPosition, pixelPosition);
    }

    /**
     * Creates a matrix consisting of TerrainTile objects which each represent a tile in the world.
     * The size of the matrix is dependent on the number of rows and columns in
     * the attribute terrainMatrix.
     */
    private void createTileMatrix() {
         for (int rowIndex = 0; rowIndex < this.terrainMatrix.size(); rowIndex++) {
             List<Integer> terrainRow = this.terrainMatrix.get(rowIndex);
             ArrayList<AViewTile> tileRow = new ArrayList<>();
             for (int columnIndex = 0; columnIndex < terrainRow.size(); columnIndex++) {
                 int id = terrainRow.get(columnIndex);
                 tileRow.add(this.initializeTerrainTile(id, columnIndex, rowIndex));
             }
             this.tileMatrix.add(tileRow);
         }
     }
}
