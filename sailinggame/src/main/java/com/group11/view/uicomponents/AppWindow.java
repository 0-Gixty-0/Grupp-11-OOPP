package com.group11.view.uicomponents;

import javax.swing.*;

import com.group11.view.AViewTileFactory;

import java.awt.*;
import java.util.List;

/**
 * AppWindow is the top-level class for the View component of the MVC design.
 * It is responsible for drawing the map terrain and entities on the map
 */
public class AppWindow extends JFrame {
    
    private StatsPanel statsPanel;
    private GameWorldPanel gameWorldPanel;
    
    /**
     * Constructor creates a new GameWorld object, a new GameEntities object, and initializes the window
     */
    public AppWindow(int windowWidth, int windowHeight, int mapWidth, int mapHeight, int tileWidth, int tileHeight) {
        super();
        AViewTileFactory.setTileDimensions(tileWidth, tileHeight);
        this.setSize(windowWidth, windowHeight);
        this.setTitle("Sailing Game");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.GRAY);
        BufferPanel bufferPanel = new BufferPanel(1000, 6);
        this.statsPanel = new StatsPanel(1000, 6);
        this.add(statsPanel); //Adding a buffering pane to make sure the game world ends up in the center of the window
        this.gameWorldPanel = new GameWorldPanel(mapWidth * tileWidth, mapHeight * tileHeight);
        this.add(gameWorldPanel);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(bufferPanel); //Adding a buffering pane to make sure the game world ends up in the center of the window
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
     * @param intMatrix The matrix of ViewTiles representing the entities.
     */
    public void updateEntities(List<List<AViewDrawable>> tileMatrix) {
        this.gameWorldPanel.updateEntityPanel(tileMatrix);
    }

    /**
     * Updates the terrain on the map.
     * @param intMatrix The matrix of ViewTiles representing the terrain.
     */
    public void updateTerrain( List<List<AViewDrawable>> tileMatrix) {
        this.gameWorldPanel.updateTerrainPanel(tileMatrix);
    }

    /**
     * Sets visibility of the main window to true
     */
    public void showGame() {
        this.setVisible(true);
    }
}
