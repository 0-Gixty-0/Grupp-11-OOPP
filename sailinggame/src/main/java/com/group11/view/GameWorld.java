package com.group11.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The GameWorld class represents the functionality and interface for represent the
 * terrain aspects of the game world such as tiles.
 */
public class GameWorld {
    private List<List<Integer>> terrainMatrix;
    private ArrayList<ArrayList<Tile>> tileMatrix = new ArrayList<>();
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
     * Returns a matrix of Tile objects
     * @return A matrix of Tile objects
     */
    public ArrayList<ArrayList<Tile>> getTileMatrix() {
        return tileMatrix;
    }


    /**
     * Helper function for initializing an object of type Tile
     * @param id The id of the terrain type
     * @param columnIndex The index of which spot in the row the tile is to be placed
     * @param rowIndex The index of which row the tile is to be placed in
     * @return A JLabel representing a tile which consists of size and location.
     */
    private Tile initializeTile(int id, int columnIndex, int rowIndex) {
        JLabel newComponent = new JLabel();
        Point matrixPosition = new Point(rowIndex, columnIndex);
        Point pixelPosition = new Point(columnIndex * this.tileWidth, rowIndex * this.tileHeight);
        newComponent.setSize(this.tileWidth,this.tileHeight);
        newComponent.setLocation(columnIndex * this.tileWidth, rowIndex * this.tileHeight);
        newComponent.setText(String.format("%d", id));
        return new Tile(id, this.tileWidth, matrixPosition, newComponent, pixelPosition);
    }

    /**
     * Creates a matrix consisting of Tile objects which each represent a tile in the world.
     * The size of the matrix is dependent on the number of rows and columns in
     * the attribute terrainMatrix.
     */
    private void createTileMatrix() {
         for (int rowIndex = 0; rowIndex < this.terrainMatrix.size(); rowIndex++) {
             List<Integer> terrainRow = this.terrainMatrix.get(rowIndex);
             ArrayList<Tile> tileRow = new ArrayList<>();
             for (int columnIndex = 0; columnIndex < terrainRow.size(); columnIndex++) {
                 int id = terrainRow.get(columnIndex);
                 tileRow.add(this.initializeTile(id, columnIndex, rowIndex));
             }
             this.tileMatrix.add(tileRow);
         }
     }
}
