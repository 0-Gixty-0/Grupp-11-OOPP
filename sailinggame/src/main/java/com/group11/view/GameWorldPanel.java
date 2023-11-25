package com.group11.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;


public class GameWorldPanel extends JPanel {

    private InnerPanel terrainPanel;
    private InnerPanel entityPanel;

    private class InnerPanel extends JPanel {

        public InnerPanel() {
            super();
            this.setOpaque(false);
            this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        }

        private void addTiles(List<List<ViewTile>> tileMatrix) {
            for (List<ViewTile> tileRow : tileMatrix) {
                for (ViewTile tile : tileRow) {
                    this.add(tile);
                }
            }
        }

        private void removeTilesFromPanel() {
            Component[] components = this.getComponents();
            
            for (Component tile : components ) {
                this.remove(tile);
            }
        }

    }

    protected GameWorldPanel(int width, int height) {
        super();
        this.setBackground(new Color(77,109,243));
        this.setPreferredSize(new Dimension(width*AViewTileFactory.getTileWidth(), height*AViewTileFactory.getTileHeight()));
        this.setLayout(new OverlayLayout(this));
        this.terrainPanel = new InnerPanel();
        this.entityPanel = new InnerPanel();
        this.add(entityPanel);
        this.add(terrainPanel);
    }

    protected void updateTerrainPanel(List<List<ViewTile>> terrainMatrix) {
        this.terrainPanel.removeTilesFromPanel();
        this.terrainPanel.addTiles(terrainMatrix);
        this.revalidate();
        this.repaint(); 
    }

    protected void updateEntityPanel(List<List<ViewTile>> entityMatrix) {
        this.entityPanel.removeTilesFromPanel();
        this.entityPanel.addTiles(entityMatrix);
        this.revalidate();
        this.repaint();
    }

}
