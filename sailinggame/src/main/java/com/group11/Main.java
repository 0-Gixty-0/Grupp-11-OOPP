package com.group11;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.group11.controller.GlobalKeyListener;
import com.group11.model.*;
import com.group11.view.AppWindow;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    private AppWindow appWindow;
    private static final GlobalKeyListener keyboardController = new GlobalKeyListener();
    private static int windowHeight;
    private static int windowWidth;
    private World world;
    private CommandableEntity player;

    public Main(int windowWidth, int windowHeight) {
        windowHeight = windowHeight;
        windowWidth = windowWidth;
        this.appWindow = new AppWindow(windowWidth, windowHeight);
        this.world = this.createBasicWorld();
        this.player = this.createBasicPlayer();
        MovementUtility.setTileMatrix(this.world.getMap().getTileMatrix());
    }

    private World createBasicWorld() {
        IMapGenerator mapGenerator = new BasicMapGenerator();
        IWorldGenerator worldGenerator = new BasicWorldGenerator(mapGenerator);
        return worldGenerator.generateWorld(47);
    }

    private CommandableEntity createBasicPlayer() {
        AMovableBody ship = new Ship(new Point(3,3));
        return new CommandableEntity(ship, "Player", true);
    }

    private void decodeController() {
        Set<Integer> request = Main.keyboardController.getInput();
        ArrayList<ArrayList<Integer>> validInputs = new ArrayList<>();
        ArrayList<Integer> input = new ArrayList<>();
        input.add(87);
        validInputs.add(input);

        for (ArrayList<Integer> valInput : validInputs) {
            if (request.containsAll(valInput)) {
                this.player.moveCommand(0);
                System.out.println("Moved up");
                System.out.println(this.player.getPos());
            }
        }
    }

    /**
     * Starts the game
     */
    public void run() throws InterruptedException {
        appWindow.showGame();
        while (true) {
            this.decodeController();
            Thread.sleep(100);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main(800,800);
        main.run();
    }
}