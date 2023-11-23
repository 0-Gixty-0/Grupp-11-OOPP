package com.group11;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.group11.view.AppWindow;

public class Main {
    private static AppWindow appWindow;
    private static int windowHeight;
    private static int windowWidth;


    /**
     * Testing purposes. Will be removed later.
     * @return Matrix of integers corresponding to entity texture id:s
     */
    private List<List<Integer>> initializeEntityTest() {
        List<List<Integer>> testEntityMatrix = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 30; i++) {
            List<Integer> row = new ArrayList<>();
            for (int k = 0; k < 60; k++) {
                int num = rand.nextInt(40);
                if (num > 0) {
                    row.add(null);
                } else {
                    row.add(0);
                }
            }
            testEntityMatrix.add(row);
        }
        return testEntityMatrix;
    }

    /**
     * Testing purposes. Will be removed later.
     * @return Matrix of integers corresponding to terrain texture id:s
     */
    private List<List<Integer>> initializeTerrainTest() {
        List<List<Integer>> testTerrainMatrix = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 30; i++) {
            List<Integer> row = new ArrayList<>();
            for (int k = 0; k < 60; k++) {
                row.add(rand.nextInt(2));
            }
            testTerrainMatrix.add(row);
        }
        return testTerrainMatrix;
    }



    public Main(int windowWidth, int windowHeight) {
        windowHeight = windowHeight;
        windowWidth = windowWidth;
        appWindow = new AppWindow(windowWidth, windowHeight);
    }

    /**
     * Starts the game
     */
    public void run() throws InterruptedException {
        appWindow.showGame();
        
        appWindow.updateTerrain(initializeTerrainTest());
        while (true) {
            appWindow.updateEntities(initializeEntityTest());
            Thread.sleep(500);
        }
        
    }

    public static void main(String[] args) throws InterruptedException{
        Main main = new Main(1500,1500);
        main.run();
    }
}