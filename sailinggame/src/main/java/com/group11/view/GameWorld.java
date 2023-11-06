package com.group11.view;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GameWorld {
    private List<List<Integer>> terrainMatrix;
    private ArrayList<ArrayList<JLabel>> tileMatrix = new ArrayList<>();
    private final int tileWidth = 16;
    private final int tileHeight = 16;
    private int windowWidth;
    private int windowHeight;

    GameWorld(List<List<Integer>> matrix, int width, int height) {
        this.terrainMatrix = matrix;
        this.windowHeight = height;
        this.windowWidth = width;
        this.createTileComponents();
    }

    public ArrayList<ArrayList<JLabel>> getTileMatrix() {
        return tileMatrix;
    }

    private JLabel initializeTile(int tileIndex, int rowIndex) {
        JLabel newTile = new JLabel();
        newTile.setSize(this.tileWidth,this.tileHeight);
        newTile.setLocation(tileIndex * this.tileWidth, rowIndex * this.tileHeight);
        return newTile;
    }

    private void createTileComponents() {
         for (int rowIndex = 0; rowIndex < this.terrainMatrix.size(); rowIndex++) {
             List<Integer> terrainRow = this.terrainMatrix.get(rowIndex);
             ArrayList<JLabel> tileRow = new ArrayList<>();
             for (int tileIndex = 0; tileIndex < terrainRow.size(); tileIndex++) {
                 int id = terrainRow.get(tileIndex);
                 JLabel newTile = this.initializeTile(tileIndex, rowIndex);
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
