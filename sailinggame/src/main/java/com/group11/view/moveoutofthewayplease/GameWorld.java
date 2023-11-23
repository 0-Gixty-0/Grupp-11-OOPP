package com.group11.view.moveoutofthewayplease;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import com.group11.view.AViewTile;
import com.group11.view.TerrainTile;

/**
 * The GameWorld class represents the functionality and interface for representing the
 * terrain aspects of the game world through tiles.
 */
public class GameWorld {

    private List<List<Integer>> terrainMatrix;
    private List<List<AViewTile>> tileMatrix;
    private final int tileWidth = 16;
    private final int tileHeight = 16;

    /**
     * GameWorld constructor sets attributes and creates tile components.
     * @param matrix A matrix consisting of tileset id:s
     * @param width  The width of the window frame
     * @param height The height of the window frame
     */
    GameWorld(List<List<Integer>>  terrainMatrix, int width, int height) {
        this.terrainMatrix = terrainMatrix;
        this.updateTileMatrix();
    }

    /**
     * Returns a matrix of ViewTile objects
     * @return A matrix of ViewTile objects
     */
    public List<List<AViewTile>> getTileMatrix() {
        return tileMatrix;
    }

    public void updateGameWorld(List<List<Integer>> terrainMatrix) {
        this.terrainMatrix = terrainMatrix;
        updateTileMatrix();
    }

    /**
     * Helper function for initializing an object of type ViewTile
     * @param id The id of the terrain type
     * @param columnIndex The index of which spot in the row the tile is to be placed
     * @param rowIndex The index of which row the tile is to be placed in
     * @return A TerrainTile object representing a terrain tile
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
    private void updateTileMatrix() {
        this.tileMatrix = new ArrayList<>();
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
