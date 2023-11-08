package com.group11.view;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * AppWindow is the top-level class for the View component of the MVC design.
 * It is responsible for drawing the map terrain and entities on the map
 */
public class AppWindow {
    private static int windowWidth;
    private static int windowHeight;
    private final GameWorld gameWorld;
    private final GameEntities gameEntities;

    private final JFrame mainFrame;

    private List<List<Integer>> terrainMatrix;
    private ArrayList<Integer> entityMatrix;

    /**
     * Constructor creates a new GameWorld object, a new GameEntities object, and initializes the window
     */
    public AppWindow(int windowWidth, int windowHeight) {
        AppWindow.windowWidth = windowWidth;
        AppWindow.windowHeight = windowHeight;
        this.terrainMatrix = this.initializeTerrainTest();
        gameWorld = new GameWorld(terrainMatrix, windowWidth, windowHeight);
        gameEntities = new GameEntities(entityMatrix);
        mainFrame = new JFrame("Sailing Game");
        this.initializeWindow();
    }

    /**
     * Testing purposes. Will be removed later.
     * @return Matrix of integers corresponding to terrain id:s
     */
    private List<List<Integer>> initializeTerrainTest() {
        List<List<Integer>> testTerrainList = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < 45; i++) {
            row.add(1);
        }
        for (int i = 0; i < 45; i++) {
            testTerrainList.add(row);
        }
        return testTerrainList;
    }

    /**
     * Initializes the mainFrame window.
     */
    private void initializeWindow() {
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(this.windowWidth, this.windowHeight);
        this.addTilesToFrame();
        mainFrame.add(new JLabel());
    }

    /**
     * Adds each JLabel component, obtained from the Tile object, on the map to the main window frame
     */
    private void addTilesToFrame() {
        ArrayList<ArrayList<AbstractTile>> tileMatrix = this.gameWorld.getTileMatrix();
        for (ArrayList<AbstractTile> tileRow : tileMatrix) {
            for (AbstractTile tile : tileRow) {
                mainFrame.add(tile.getComponent());
            }
        }
    }

    /**
     * Sets visibility of the main window to true
     */
    public void drawGame() {
        mainFrame.setVisible(true);
    }
}
