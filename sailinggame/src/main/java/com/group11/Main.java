package com.group11;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.group11.application.EntitySpawner;
import com.group11.controller.KeyboardInterpretor;
import com.group11.model.builders.EntityDirector;
import com.group11.model.builders.ShipBuilder;
import com.group11.model.gameentites.AEntity;
import com.group11.model.gameentites.CommandableEntity;
import com.group11.model.gameworld.AdvancedMapGenerator;
import com.group11.model.gameworld.BasicWorldGenerator;
import com.group11.model.gameworld.IMapGenerator;
import com.group11.model.gameworld.IWorldGenerator;
import com.group11.model.gameworld.World;
import com.group11.model.utility.*;
import com.group11.view.uicomponents.AppWindow;

class Main {

    private AppWindow appWindow;
    private int mapWidth;
    private int mapHeight;
    private static final KeyboardInterpretor keyboardInterpreter = new KeyboardInterpretor();
    private AICommander aiCommander;
    private int waveNumber = 1;
    private World world;
    private CommandableEntity player;
    private List<List<AEntity>> entityMatrix;
    private List<CommandableEntity> enemyList;
    private List<AEntity> entityList = new ArrayList<>();
    private EntityDirector director;
    private EntitySpawner entitySpawner;

    public Main(int windowWidth, int windowHeight, int mapWidth, int mapHeight) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.appWindow = new AppWindow(windowWidth, windowHeight, mapWidth, mapHeight, 16, 16);
        this.director = new EntityDirector(new ShipBuilder());
        this.world = this.createBasicWorld();
        this.entitySpawner = new EntitySpawner(this.world, this.director);
        this.initializeEntities();
        UMovementUtility.setTileMatrix(this.world.getMap().getTileMatrix());
        this.aiCommander = new AICommander(this.entityMatrix, this.world.getMap().getTileMatrix());
        this.appWindow.updateTerrain((UTileMatrixDecoder.decodeIntoIntMatrix(world.getMap().getTileMatrix())));
        this.appWindow.updateEntities(UEntityMatrixDecoder.decodeIntoIntMatrix(this.entityMatrix));
    }

    private void initializeEntities() {
        this.entityMatrix = UEntityMatrixGenerator.createEntityMatrix(this.mapWidth, this.mapHeight);
        this.enemyList = this.entitySpawner.createEnemyWave(this.waveNumber);
        this.player = this.createBasicPlayer();
        this.entityList.add(player);
        this.entityList.addAll(this.enemyList);
        UEntityMatrixGenerator.populateEntityMatrix(this.entityList, this.entityMatrix);
    }

    private World createBasicWorld() {
        IMapGenerator mapGenerator = new AdvancedMapGenerator();
        IWorldGenerator worldGenerator = new BasicWorldGenerator(mapGenerator);
        return worldGenerator.generateWorld(this.mapWidth,this.mapWidth);
    }

    private CommandableEntity createBasicPlayer() {
        return (CommandableEntity) this.entitySpawner.spawnPlayer();
    }

    private void updateEntityMatrix() {
        this.entityMatrix = UEntityMatrixGenerator.createEntityMatrix(this.mapWidth, this.mapHeight);
        UEntityMatrixGenerator.populateEntityMatrix(this.entityList, this.entityMatrix);
        this.aiCommander.setEntityMatrix(this.entityMatrix);
        appWindow.updateEntities(UEntityMatrixDecoder.decodeIntoIntMatrix(this.entityMatrix));
    }

    /**
     * Starts the game
     */
    public void run() throws InterruptedException {
        appWindow.showGame();
        while (true) {
            updatePlayer();
            this.aiCommander.moveEnemies(this.enemyList);
            this.updateEntityMatrix();
            Thread.sleep(50);
        }
    }

    private void updatePlayer() {
        int movementInput = this.keyboardInterpreter.getMovementInput();
        if (movementInput >= 0) {
            this.player.moveIfAble(movementInput);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main(800,800, 50, 50);
        main.run();
    }
}