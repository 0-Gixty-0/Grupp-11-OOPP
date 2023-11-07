package com.group11.view;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * AppWindow is the top-level class for the View component of the MVC design.
 * It is responsible for drawing the map terrain and entities on the map
 */
public class AppWindow {
    private final int windowWidth = 800;
    private final int windowHeight = 800;
    private final GameWorld gameWorld;
    private final GameEntities gameEntities;

    private final JFrame mainFrame;

    private List<List<Integer>> terrainMatrix;
    private ArrayList<Integer> entityMatrix;

    /**
     * Constructor creates a new GameWorld object, a new GameEntities object, and initializes the window
     */
    AppWindow() {
        this.terrainMatrix = this.initializeTerrainTest();
        gameWorld = new GameWorld(terrainMatrix, this.windowWidth, this.windowHeight);
        gameEntities = new GameEntities(entityMatrix);
        mainFrame = new JFrame("Sailing Game");
        this.initializeWindow();
    }

    /**
     * Testing purposes. Will be removed later.
     * @return {List<List<Integer>>} Matrix of integers corresponding to terrain id:s
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
     * Adds each JLabel component which corresponds to a tile on the map to the main window frame
     */
    private void addTilesToFrame() {
        ArrayList<ArrayList<JLabel>> tileMatrix = this.gameWorld.getTileMatrix();
        for (ArrayList<JLabel> tileRow : tileMatrix) {
            for (JLabel tile : tileRow) {
                System.out.println(tile);
                mainFrame.add(tile);
            }
        }
    }

    /**
     * Sets visibility of the main window to true
     */
    public void drawGame() {
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        AppWindow window = new AppWindow();
        window.drawGame();
    }
}
