package com.group11.view;

import java.util.ArrayList;
import java.util.List;
import java.awt.Dimension;
import java.awt.Point;

public class ViewTileMatrixEncoder {
    
    private static int tileWidth;
    private static int tileHeight;
    private static AViewTileFactory entityTileFactory = new EntityTileFactory();
    private static AViewTileFactory terrainTileFactory = new TerrainTileFactory();

    private ViewTileMatrixEncoder() {
        throw new IllegalStateException("Utility class");
    }

    protected static void setTileDimensions(int tileWidth, int tileHeight) {
        ViewTileMatrixEncoder.tileWidth = tileWidth;
        ViewTileMatrixEncoder.tileHeight = tileHeight;
    }

    protected static int getTileWidth() {
        return tileWidth;
    }

    protected static int getTileHeight() {
        return tileHeight;
    }

    protected static List<List<ViewTile>> createEntityTileMatrix(List<List<Integer>> intMatrix) {

        List<List<ViewTile>> tileMatrix = new ArrayList<>();

        for (int rowIndex = 0; rowIndex < intMatrix.size(); rowIndex++) {

            List<Integer> intRow = intMatrix.get(rowIndex);

            List<ViewTile> tileRow = new ArrayList<>();

            for (int columnIndex = 0; columnIndex < intRow.size(); columnIndex++) {
                try {
                    int id = intRow.get(columnIndex);
                    tileRow.add(entityTileFactory.createTile(id, 
                                                            new Dimension(tileWidth,tileHeight),
                                                            new Point(rowIndex * tileHeight, columnIndex * tileWidth),
                                                            new Point(columnIndex * tileWidth, rowIndex * tileHeight)));
                } catch (NullPointerException e) {
                    tileRow.add(null);
                }
            }
            
            tileMatrix.add(tileRow);
        }
        
        return tileMatrix;
    }

    protected static List<List<ViewTile>> createTerrainTileMatrix(List<List<Integer>> intMatrix) {

        List<List<ViewTile>> tileMatrix = new ArrayList<>();

        for (int rowIndex = 0; rowIndex < intMatrix.size(); rowIndex++) {

            List<Integer> intRow = intMatrix.get(rowIndex);

            List<ViewTile> tileRow = new ArrayList<>();

            for (int columnIndex = 0; columnIndex < intRow.size(); columnIndex++) {
                try {
                int id = intRow.get(columnIndex);
                tileRow.add(terrainTileFactory.createTile(id, 
                                                            new Dimension(tileWidth,tileHeight),
                                                            new Point(rowIndex * tileHeight, columnIndex * tileWidth),
                                                            new Point(columnIndex * tileWidth, rowIndex * tileHeight)));
                } catch (NullPointerException e) {
                    tileRow.add(null);
                }
            }
            
            tileMatrix.add(tileRow);
        }
        
        return tileMatrix;
    }


}
