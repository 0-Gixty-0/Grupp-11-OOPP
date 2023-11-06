package com.group11.view;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppWindow {
    private final int windowWidth = 800;
    private final int windowHeight = 800;
    private final GameWorld gameWorld;
    private final GameEntities gameEntities;

    private final JFrame mainFrame;

    private List<List<Integer>> terrainMatrix;
    private ArrayList<Integer> entityMatrix;

    AppWindow() {
        this.terrainMatrix = this.initializeTerrainTest();
        gameWorld = new GameWorld(terrainMatrix, this.windowWidth, this.windowHeight);
        gameEntities = new GameEntities(entityMatrix);
        mainFrame = new JFrame("Sailing Game");
        this.initializeWindow();
    }

    private List<List<Integer>> initializeTerrainTest() {
        List<List<Integer>> testTerrainList = new ArrayList<>();
        List<Integer> list = Arrays.asList(1,2,3,4);
        testTerrainList.add(list);
        testTerrainList.add(list);
        testTerrainList.add(list);
        testTerrainList.add(list);
        return testTerrainList;
    }

    private void initializeWindow() {
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(this.windowWidth, this.windowHeight);
        this.addTilesToFrame();
        mainFrame.add(new JLabel());
    }

    private void addTilesToFrame() {
        ArrayList<ArrayList<JLabel>> tileMatrix = this.gameWorld.getTileMatrix();
        for (ArrayList<JLabel> tileRow : tileMatrix) {
            for (JLabel tile : tileRow) {
                System.out.println(tile);
                mainFrame.add(tile);
            }
        }
    }

    public void drawGame() {
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        AppWindow window = new AppWindow();
        window.drawGame();
    }
}
