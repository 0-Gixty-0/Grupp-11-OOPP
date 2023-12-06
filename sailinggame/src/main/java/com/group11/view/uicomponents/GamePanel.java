package com.group11.view.uicomponents;

import javax.swing.*;

import com.group11.view.AViewTileFactory;
import com.group11.view.ViewTileMatrixEncoder;

import java.awt.*;
import java.util.List;

/**
 * AppWindow is the top-level class for the View component of the MVC design.
 * It is responsible for containing all other components of the UI.
 */
public class GamePanel extends JPanel {
    
    private StatsPanel statsPanel;
    private GameWorldPanel gameWorldPanel;
    
    /**
     * Constructor for creating a GamePanel.
     * @param width width of the panel
     * @param height height of the panel
     * @param mapWidth width of the map
     * @param mapHeight height of the map
     * @param tileWidth width of the tiles
     * @param tileHeight height of the tiles
     */
    public GamePanel(int width, int height, int mapWidth, int mapHeight, int tileWidth, int tileHeight) {
        super();
        
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(java.awt.Color.GRAY);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        this.statsPanel = new StatsPanel(1000, 80);
        this.gameWorldPanel = new GameWorldPanel(mapWidth * tileWidth, mapHeight * tileHeight);

        AViewTileFactory.setTileDimensions(tileWidth, tileHeight);
        BufferPanel bufferPanel = new BufferPanel(1000, 80);

        this.add(statsPanel); //Adding a buffer pane to make sure the game world ends up in the center of the window
        this.add(gameWorldPanel);
        this.add(bufferPanel); //Adding a buffer pane to make sure the game world ends up in the center of the window
    }

    /**
     * Updates the hp label in the stats panel.
     * @param newHp The new hp value.
     */
    public void updateHp(int newHp) {
        statsPanel.setHpLabel(newHp);
    }

    /**
     * Updates the lvl label in the stats panel.
     * @param newLvl The new lvl value.
     */
    public void updateLvl(int newLvl) {
        statsPanel.setLvlLabel(newLvl);
    }

    /**
     * Updates the score label in the stats panel.
     * @param newScore The new score value.
     */
    public void updateScore(int newScore) {
        statsPanel.setScoreLabel(newScore);
    }

    /**
     * Updates the entities on the map.
     * @param intMatrix The matrix of integers representing the entities.
     */
    public void updateEntities(List<List<Integer>> intMatrix) {
        List<List<ViewTile>> tileMatrix = ViewTileMatrixEncoder.createEntityTileMatrix(intMatrix);
        this.gameWorldPanel.updateEntityPanel(tileMatrix);
    }

    /**
     * Updates the terrain on the map.
     * @param intMatrix The matrix of integers representing the terrain.
     */
    public void updateTerrain(List<List<Integer>> intMatrix) {
        List<List<ViewTile>> tileMatrix = ViewTileMatrixEncoder.createTerrainTileMatrix(intMatrix);
        this.gameWorldPanel.updateTerrainPanel(tileMatrix);
    }
}
