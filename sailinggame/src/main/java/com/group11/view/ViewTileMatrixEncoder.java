package com.group11.view;

import java.util.ArrayList;
import java.util.List;

import java.awt.Dimension;
import java.awt.Point;

public class ViewTileMatrixEncoder {
    
    private static int tileWidth;
    private static int tileHeight;

    private ViewTileMatrixEncoder() {
        throw new IllegalStateException("Utility class");
    }

    private static ViewTile initializeTile(int id, int columnIndex, int rowIndex) {
        Dimension dimension = new Dimension(tileWidth, tileHeight);
        Point matrixPosition = new Point(rowIndex, columnIndex);
        Point pixelPosition = new Point(columnIndex * tileWidth, rowIndex * tileHeight);
        return ViewTileFactory.createTile(id, dimension, matrixPosition, pixelPosition);
    }

    protected static void setTileDimensions(int width, int height) {
        tileWidth = width;
        tileHeight = height;
    }

    protected static int getTileWidth() {
        return tileWidth;
    }

    protected static int getTileHeight() {
        return tileHeight;
    }

    protected static List<List<ViewTile>> createTileMatrix(List<List<Integer>> terrainMatrix) {

        List<List<ViewTile>> tileMatrix = new ArrayList<>();

        for (int rowIndex = 0; rowIndex < terrainMatrix.size(); rowIndex++) {

            List<Integer> terrainRow = terrainMatrix.get(rowIndex);

            List<ViewTile> tileRow = new ArrayList<>();

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
