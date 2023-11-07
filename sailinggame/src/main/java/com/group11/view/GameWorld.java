package com.group11.view;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The GameWorld class represents the functionality and interface for represent the
 * terrain aspects of the game world such as tiles.
 */
public class GameWorld {
    private List<List<Integer>> terrainMatrix;
    private ArrayList<ArrayList<JLabel>> tileMatrix = new ArrayList<>();
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
        this.createTileComponents();
    }

    /**
     * Returns a matrix of Jlabels representing tiles
     * @return A matrix of Jlabels representing tiles
     */
    public ArrayList<ArrayList<JLabel>> getTileMatrix() {
        return tileMatrix;
    }


    /**
     * Helper function for initializing a single tile which consists of a JLabel
     * @param tileIndex The index of which spot in the row the tile is to be placed
     * @param rowIndex The index of which row the tile is to be placed in
     * @return A JLabel representing a tile which consists of size and location.
     */
    private JLabel initializeTile(int tileIndex, int rowIndex) {
        JLabel newTile = new JLabel();
        newTile.setSize(this.tileWidth,this.tileHeight);
        newTile.setLocation(tileIndex * this.tileWidth, rowIndex * this.tileHeight);
        return newTile;
    }

    /**
     * Creates a matrix consisting of JLabels which each represent a tile in the world.
     * The size of the matrix is dependent on the number of rows and columns in
     * the attribute terrainMatrix.
     * The id of each tile must be in the interval 1-4
     */
    private void createTileComponents() {
         for (int rowIndex = 0; rowIndex < this.terrainMatrix.size(); rowIndex++) {
             List<Integer> terrainRow = this.terrainMatrix.get(rowIndex);
             ArrayList<JLabel> tileRow = new ArrayList<>();
             for (int tileIndex = 0; tileIndex < terrainRow.size(); tileIndex++) {
                 int id = terrainRow.get(tileIndex);
                 JLabel newTile = this.initializeTile(tileIndex, rowIndex);
                 // Below code is to be removed once a functional tileset system is in place
                 // Testing purposes below!!!
                 switch(id) {
                     case 1:
                         newTile.setText("1");
                         tileRow.add(newTile);
                         break;
                     case 2:
                         newTile.setText("2");
                         tileRow.add(newTile);
                         break;
                     case 3:
                         newTile.setText("3");
                         tileRow.add(newTile);
                         break;
                     case 4:
                         newTile.setText("4");
                         tileRow.add(newTile);
                         break;
                 }
             }
             this.tileMatrix.add(tileRow);
         }
     }
}
