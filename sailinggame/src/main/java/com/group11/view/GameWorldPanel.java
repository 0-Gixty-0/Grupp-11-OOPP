package com.group11.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;
import java.awt.Point;

import javax.swing.JPanel;

public class GameWorldPanel extends JPanel {

    List<List<AViewTile>> tileMatrix;
    List<List<AViewTile>> entityMatrix;
    
    protected GameWorldPanel(int width, int height, List<List<AViewTile>> tileMatrix, List<List<AViewTile>> entityMatrix) {
        super();
        this.tileMatrix = tileMatrix;
        this.entityMatrix = entityMatrix;
        this.setBackground(new Color(77,109,243));
        this.setPreferredSize(new Dimension(width*16, height*16));
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        this.addTilesToPanel();
    }

    /**
     * Adds each JLabel component, obtained from the AViewTile object, on the map to the main window frame.
     * If a position in the entity tile matrix is null then the terrain component will be added.
     * Otherwise, the entity tile component for that position will be added.
     */
    private void addTilesToPanel() {
        for (List<AViewTile> tileRow : tileMatrix) {
            for (AViewTile tile : tileRow) {
                Point matrixPosition = tile.getMatrixPosition();
                if (entityMatrix.get(matrixPosition.x).get(matrixPosition.y) == null) {
                    this.add(tile.getComponent());
                } else {
                    this.add(entityMatrix.get(matrixPosition.x).get(matrixPosition.y).getComponent());
                }
            }
        }
    }

}
