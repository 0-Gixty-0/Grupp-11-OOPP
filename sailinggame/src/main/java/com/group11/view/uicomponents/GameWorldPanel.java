package com.group11.view.uicomponents;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

/**
 * The class is a JPanel that is used as a container for the game terrain and game entities.
 */
public class GameWorldPanel extends JPanel {

    private InnerPanel terrainPanel;
    private InnerPanel entityPanel;

    /**
     * The class is a JPanel that can hold entities or terrain tiles.
     */
    private class InnerPanel extends JPanel {

        /**
         * Constructor for creating an InnerPanel.
         */
        private InnerPanel() {
            super();
            this.setOpaque(false);
            this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        }

        /**
         * Add the tiles to the panel.
         * @param tileMatrix The matrix of tiles to be added.
         */
        private void addTiles(List<List<AViewDrawable>> tileMatrix) {
            for (List<AViewDrawable> tileRow : tileMatrix) {
                for (AViewDrawable tile : tileRow) {
                    this.add(tile);
                }
            }
        }

        /**
         * Remove all tiles from the panel.
         */
        private void removeTilesFromPanel() {
            Component[] components = this.getComponents();
            
            for (Component tile : components ) {
                this.remove(tile);
            }
        }

    }

    /**
     * Constructor for creating a GameWorldPanel.
     * @param width width of the panel
     * @param height height of the panel
     */
    protected GameWorldPanel(int width, int height) {
        super();
        this.setBackground(new Color(77,109,243));
        this.setPreferredSize(new Dimension(width, height));
        this.setLayout(new OverlayLayout(this));
        this.terrainPanel = new InnerPanel();
        this.entityPanel = new InnerPanel();
        this.add(entityPanel);
        this.add(terrainPanel);
    }

    /**
     * Update the terrain panel with the new terrain matrix.
     * @param terrainMatrix The new terrain matrix.
     */
    protected void updateTerrainPanel(List<List<AViewDrawable>> terrainMatrix) {
        this.terrainPanel.removeTilesFromPanel();
        this.terrainPanel.addTiles(terrainMatrix);
        this.revalidate();
        this.repaint(); 
    }

    /**
     * Update the entity panel with the new entity matrix.
     * @param entityMatrix The new entity matrix.
     */
    protected void updateEntityPanel(List<List<AViewDrawable>> entityMatrix) {
        this.entityPanel.removeTilesFromPanel();
        this.entityPanel.addTiles(entityMatrix);
        this.revalidate();
        this.repaint();
    }

}
