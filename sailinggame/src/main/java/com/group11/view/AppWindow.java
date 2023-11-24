package com.group11.view;

import javax.swing.*;

import java.awt.*;
import java.util.List;

/**
 * AppWindow is the top-level class for the View component of the MVC design.
 * It is responsible for drawing the map terrain and entities on the map
 */
public class AppWindow extends JFrame {
    
    private BufferPanel bufferPanel;
    private StatsPanel statsPanel;
    private GameWorldPanel gameWorldPanel;
    private int mapHeight;
    private int mapWidth;

    /**
     * Constructor creates a new GameWorld object, a new GameEntities object, and initializes the window
     */
    public AppWindow(int windowWidth, int windowHeight, int mapWidth, int mapHeight, int tileWidth, int tileHeight) {
        super();
        this.mapHeight = mapHeight;
        this.mapWidth = mapWidth;
        ViewTileMatrixEncoder.setTileDimensions(tileWidth, tileHeight);
        this.setSize(windowWidth, windowHeight);
        this.setTitle("Sailing Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.GRAY);
        this.addComponents();
    }

    /**
     * Initializes the mainFrame window.
     */
    private void addComponents() {

        this.bufferPanel = new BufferPanel(1000, 6);

        this.statsPanel = new StatsPanel(1000, 6);

        this.add(statsPanel); //Adding a buffering pane to make sure the game world ends up in the center of the window
        
        this.gameWorldPanel = new GameWorldPanel(mapWidth, mapHeight);

        this.add(gameWorldPanel);
        
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        this.add(bufferPanel); //Adding a buffering pane to make sure the game world ends up in the center of the window
    }

    public void updateHp() {
        // @TODO set hp
    }

    public void updateLvl() {
        // @TODO set lvl
    }

    public void updateScore() {
        // @TODO set score
    }

    public void updateEntities( List<List<Integer>> intMatrix) {
        List<List<ViewTile>> tileMatrix = ViewTileMatrixEncoder.createEntityTileMatrix(intMatrix);
        this.gameWorldPanel.updateEntityMatrix(tileMatrix);
    }

    public void updateTerrain( List<List<Integer>> intMatrix) {
        List<List<ViewTile>> tileMatrix = ViewTileMatrixEncoder.createTerrainTileMatrix(intMatrix);
        this.gameWorldPanel.updateTerrainMatrix(tileMatrix);
    }

    /**
     * Sets visibility of the main window to true
     */
    public void showGame() {
        this.setVisible(true);
    }
}
