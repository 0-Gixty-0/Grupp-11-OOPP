package com.group11;

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
    private EntitySpawner entitySpawner;

    /**
     * Constructor method performs the following tasks:
     * Creates the app window used to display the game
     * Creates an entity director and spawner
     * Creates the game world in the model
     * Creates initial entities when starting the game
     * Sets tile matrix in UMovementUtility
     * Creates the AI Commander
     * Updates the window's displayed terrain
     * Updates the window's diplayed entities
     * @param windowWidth Width of Swing window
     * @param windowHeight Height of Swing window
     * @param mapWidth Width of game map
     * @param mapHeight Height of game map
     */
    public Main(int windowWidth, int windowHeight, int mapWidth, int mapHeight) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.appWindow = new AppWindow(windowWidth, windowHeight, mapWidth, mapHeight, 16, 16);
        this.world = this.createBasicWorld();
        this.entitySpawner = new EntitySpawner(this.world, new ShipBuilder());
        this.initializeEntities();
        UMovementUtility.setTileMatrix(this.world.getMap().getTileMatrix());
        this.aiCommander = new AICommander(this.entityMatrix, this.world.getMap().getTileMatrix());
        this.appWindow.updateTerrain((UTileMatrixDecoder.decodeIntoIntMatrix(world.getMap().getTileMatrix())));
        this.appWindow.updateEntities(UEntityMatrixDecoder.decodeIntoIntMatrix(this.entityMatrix));
    }

    /**
     * Initializes the entities upon starting the game by creating the player and spawning a level one wave
     * of enemies. It then adds these entities to the entity list and creates the entity matrix
     */
    private void initializeEntities() {
        this.entityMatrix = UEntityMatrixGenerator.createEntityMatrix(this.mapWidth, this.mapHeight);
        this.enemyList = this.entitySpawner.createEnemyWave(this.waveNumber);
        this.player = this.createBasicPlayer();
        this.entityList.add(player);
        this.entityList.addAll(this.enemyList);
        UEntityMatrixGenerator.populateEntityMatrix(this.entityList, this.entityMatrix);
    }

    /**
     * Creates a basic world using the map and world generator. That being the random map generator.
     * @return A randomly generated world
     */
    private World createBasicWorld() {
        IMapGenerator mapGenerator = new AdvancedMapGenerator();
        IWorldGenerator worldGenerator = new BasicWorldGenerator(mapGenerator);
        return worldGenerator.generateWorld(this.mapWidth,this.mapWidth);
    }

    /**
     * Creates the basic version of a player using the entity spawner
     * @return The model representation of a player
     */
    private CommandableEntity createBasicPlayer() {
        return (CommandableEntity) this.entitySpawner.spawnPlayer();
    }

    /**
     * Updates the entity matrix from the entity list and updates the visual representation of entities in the frame
     */
    private void updateEntityMatrix() {
        this.entityMatrix = UEntityMatrixGenerator.createEntityMatrix(this.mapWidth, this.mapHeight);
        UEntityMatrixGenerator.populateEntityMatrix(this.entityList, this.entityMatrix);
        this.aiCommander.setEntityMatrix(this.entityMatrix);
        appWindow.updateEntities(UEntityMatrixDecoder.decodeIntoIntMatrix(this.entityMatrix));
    }

    /**
     * Starts the game.
     * Checks if all enemies have been defeated. If true generates a new wave of enemies.
     * Proceeds to check for movement input from player and updates enemy positions.
     * Then updates the view
     */
    public void run() throws InterruptedException {
        appWindow.showGame();
        while (true) {
            if (this.enemyList.isEmpty()) {
                this.waveNumber++;
                this.enemyList = this.entitySpawner.createEnemyWave(this.waveNumber);
            }
            updatePlayer();
            this.aiCommander.moveEnemies(this.enemyList);
            this.updateEntityMatrix();
            Thread.sleep(50);
        }
    }

    /**
     * Updates player position based on keyboard input
     */
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