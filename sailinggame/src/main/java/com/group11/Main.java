package com.group11;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import com.group11.application.EntitySpawner;
import com.group11.controller.KeyboardInterpretor;
import com.group11.model.builders.ShipBuilder;
import com.group11.model.gameentites.AEntity;
import com.group11.model.gameentites.CommandableEntity;
import com.group11.model.gameworld.AdvancedMapGenerator;
import com.group11.model.gameworld.BasicWorldGenerator;
import com.group11.model.gameworld.IMapGenerator;
import com.group11.model.gameworld.IWorldGenerator;
import com.group11.model.gameworld.World;
import com.group11.model.utility.AICommander;
import com.group11.model.utility.UEntityMatrixDecoder;
import com.group11.model.utility.UEntityMatrixGenerator;
import com.group11.model.utility.UMovementUtility;
import com.group11.model.utility.UTileMatrixDecoder;
import com.group11.view.uicomponents.AppFrame;
import com.group11.view.uicomponents.GameOverPanel;
import com.group11.view.uicomponents.GamePanel;
import com.group11.view.uicomponents.MainMenuPanel;

class Main {

    private AppFrame appWindow;
    private GamePanel gameView;
    private MainMenuPanel mainMenuView;
    private GameOverPanel gameOverView;
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
        this.gameView = new GamePanel(windowWidth, windowHeight, mapWidth, mapHeight, 16, 16);
        this.mainMenuView = new MainMenuPanel(windowWidth, windowHeight);
        this.gameOverView = new GameOverPanel(windowWidth, windowHeight);
        this.appWindow = new AppFrame(windowWidth, windowHeight);
    }

    public static void main(String[] args) throws InterruptedException {
        // proportion between window size and map size needs to be equal, application works when it isnt but it looks weird
        Main main = new Main(1000,1000, 50, 35);
        main.run();
    }

    /**
     * Main menu loop: Displays main menu and waits for user to press start game button
     * Game loop: Updates player position based on keyboard input, moves enemies, updates entity matrix.
     * Game over loop: Displays game over screen and waits for user to press back to menu button
     */
    public void run() throws InterruptedException {
        this.gameView.setVisible(true);
        appWindow.setVisible(true);

        while (true) { 

            addViewToWindow(mainMenuView);

            while (Thread.currentThread().isAlive()) {
                Thread.sleep(50);
                if (this.mainMenuView.getStartButtonPressed()) { // Main menu loop
                    removeViewFromWindow(mainMenuView);
                    addViewToWindow(gameView);
                    this.mainMenuView.resetStartButtonPressed();
                    this.initializeGame();
                    break;
                }
            }

            while (true) { // Game loop
                if (this.enemyList.isEmpty()) {
                    this.waveNumber++;
                    this.enemyList = this.entitySpawner.createEnemyWave(this.waveNumber);
                }
                updatePlayer();
                this.aiCommander.moveEnemies(this.enemyList);
                this.updateEntityMatrix();
                Thread.sleep(50);

                if (this.player.getBody().getPos().getX() == 0) { // Game over
                    removeViewFromWindow(gameView);
                    addViewToWindow(gameOverView);
                    this.gameOverView.setScoreLabel(0);
                    break;
                }
            }

            while (true) { // Game over loop
                Thread.sleep(50);
                if (this.gameOverView.getBackToMenuButtonPressed()) {
                    removeViewFromWindow(gameOverView);
                    addViewToWindow(mainMenuView);
                    this.gameOverView.resetBackToMenuButtonPressed();
                    break;
                }
            }
        }
    }

    /**
     * Initializes the game upon pressing start game button by creating the player and spawning a level one wave
     * of enemies. It then adds these entities to the entity list and creates the entity matrix
     */
    private void initializeGame() {
        this.entityList.clear();
        this.world = this.createBasicWorld();
        this.entitySpawner = new EntitySpawner(this.world, new ShipBuilder());
        UMovementUtility.setTileMatrix(this.world.getMap().getTileMatrix());
        this.entityMatrix = UEntityMatrixGenerator.createEntityMatrix(this.mapWidth, this.mapHeight);
        this.aiCommander = new AICommander(this.entityMatrix, this.world.getMap().getTileMatrix());
        this.enemyList = this.entitySpawner.createEnemyWave(this.waveNumber);
        this.player = this.createBasicPlayer();
        this.entityList.add(player);
        this.entityList.addAll(this.enemyList);
        UEntityMatrixGenerator.populateEntityMatrix(this.entityList, this.entityMatrix);
        this.gameView.updateTerrain((UTileMatrixDecoder.decodeIntoIntMatrix(world.getMap().getTileMatrix())));
        this.gameView.updateEntities(UEntityMatrixDecoder.decodeIntoIntMatrix(this.entityMatrix));
    }

    /**
     * Creates a basic world using the map and world generator. That being the random map generator.
     * @return A randomly generated world
     */
    private World createBasicWorld() {
        IMapGenerator mapGenerator = new AdvancedMapGenerator();
        IWorldGenerator worldGenerator = new BasicWorldGenerator(mapGenerator);
        return worldGenerator.generateWorld(this.mapWidth,this.mapHeight);
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
        this.gameView.updateEntities(UEntityMatrixDecoder.decodeIntoIntMatrix(this.entityMatrix));
    }

    /**
     * Adds a view to the window
     * @param view The view to be added
     */
    private void addViewToWindow(JComponent view) {
        this.appWindow.add(view);
        this.appWindow.validate();
    }

    /**
     * Removes a view from the window
     * @param view The view to be removed
     */
    private void removeViewFromWindow(JComponent view) {
        this.appWindow.remove(view);
        this.appWindow.repaint();
    }

    /**
     * Updates player position based on keyboard input
     */
    private void updatePlayer() {
        int movementInput = keyboardInterpreter.getMovementInput();
        if (movementInput >= 0) {
            this.player.moveIfAble(movementInput);
        }
    }

}