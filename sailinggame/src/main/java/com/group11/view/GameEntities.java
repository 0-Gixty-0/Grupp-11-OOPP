package com.group11.view;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The GameEntities class represents the interface and functionality of each entity in the game.
 */
public class GameEntities {
    private List<List<Integer>> entityMatrix;
    private List<List<AViewTile>> tileMatrix = new ArrayList<>();
    private final int tileWidth = 16;
    private final int tileHeight = 16;

    GameEntities(List<List<Integer>> entityMatrix) {
        this.entityMatrix = entityMatrix;
        this.createTileMatrix();
    }

    private AViewTile initializeEntityTile(int id, int columnIndex, int rowIndex) {
        Dimension dimension = new Dimension(this.tileWidth, this.tileHeight);
        Point matrixPosition = new Point(rowIndex, columnIndex);
        Point pixelPosition = new Point(columnIndex * this.tileWidth, rowIndex * this.tileHeight);
        return new EntityTile(id, dimension, matrixPosition, pixelPosition);
    }

    private void createTileMatrix() {
        for (int rowIndex = 0; rowIndex < this.entityMatrix.size(); rowIndex++) {
            List<Integer> terrainRow = this.entityMatrix.get(rowIndex);
            ArrayList<AViewTile> tileRow = new ArrayList<>();
            for (int columnIndex = 0; columnIndex < terrainRow.size(); columnIndex++) {
                int id = terrainRow.get(columnIndex);
                tileRow.add(this.initializeEntityTile(id, columnIndex, rowIndex));
            }
            this.tileMatrix.add(tileRow);
        }
    }
}
