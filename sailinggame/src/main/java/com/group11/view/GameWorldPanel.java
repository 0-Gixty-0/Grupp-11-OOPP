package com.group11.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;
import java.awt.Point;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

import com.group11.model.ATile;

public class GameWorldPanel extends JPanel {

    private InnerPanel terrainPanel;
    private InnerPanel entityPanel;

    private class InnerPanel extends JPanel {

        public InnerPanel() {
            super();
            this.setOpaque(false);
            this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        }

        private void addTiles(List<List<AViewTile>> tileMatrix) {
            for (List<AViewTile> tileRow : tileMatrix) {
                for (AViewTile tile : tileRow) {

                    if (tile == null) {
                        JLabel opaqueLabel = new JLabel();
                        opaqueLabel.setPreferredSize(new Dimension(16,16));
                        opaqueLabel.setOpaque(false);
                        this.add(opaqueLabel);
                    }
                    else {
                        this.add(tile.getComponent());
                    }
                }
            }
        }

        private void removeTilesFromPanel() {
            Component[] components = this.getComponents();
            if (components.length == 0) {
                return;
            }
            for (Component tile : components ) {
                this.remove(tile);
            }
        }

    }

    protected GameWorldPanel(int width, int height) {
        super();
        this.setBackground(new Color(77,109,243));
        this.setPreferredSize(new Dimension(width*16, height*16));
        this.setLayout(new OverlayLayout(this));
        this.terrainPanel = new InnerPanel();
        this.entityPanel = new InnerPanel();
        this.add(entityPanel);
        this.add(terrainPanel);
    }

    protected void updateTerrainMatrix(List<List<AViewTile>> terrainMatrix) {
        this.terrainPanel.removeTilesFromPanel();
        this.terrainPanel.addTiles(terrainMatrix);
        this.revalidate();
        this.repaint(); 
        
    }

    protected void updateEntityMatrix(List<List<AViewTile>> entityMatrix) {
       
        this.entityPanel.removeTilesFromPanel();
        this.entityPanel.addTiles(entityMatrix);
        this.revalidate();
        this.repaint();
    }

}
