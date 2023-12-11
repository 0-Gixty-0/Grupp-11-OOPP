package com.group11.application;

import java.util.ArrayList;
import java.util.List;

import com.group11.controller.KeyboardInterpretor;
import com.group11.model.builders.ShipBuilder;
import com.group11.model.gameentites.AEntity;
import com.group11.model.gameentites.CommandableEntity;
import com.group11.model.gameentites.ProjectileEntity;
import com.group11.model.gameworld.AdvancedMapGenerator;
import com.group11.model.gameworld.BasicWorldGenerator;
import com.group11.model.gameworld.IMapGenerator;
import com.group11.model.gameworld.IWorldGenerator;
import com.group11.model.gameworld.World;
import com.group11.model.utility.AICommander;
import com.group11.model.utility.UEntityCollisionUtility;
import com.group11.model.utility.UEntityMatrixDecoder;
import com.group11.model.utility.UEntityMatrixGenerator;
import com.group11.model.utility.UMovementUtility;
import com.group11.model.utility.UTileMatrixDecoder;
import com.group11.view.uicomponents.AppFrame;
import com.group11.view.uicomponents.GameOverPanel;
import com.group11.view.uicomponents.GamePanel;
import com.group11.view.uicomponents.MainMenuPanel;

/**
 * A class containing logic specific to the SailingGame application. The idea of our project was to make the source
 * code as extendable as possibile, therefore if you wanted to create a new game you would only need to change this class.
 */
public class SailingGameApplication extends AApplication {

    private static final int WINDOWWITH = 1100;
    private static final int WINDOWHEIGHT = 1000;
    private static final int MAPWIDTH = 65;
    private static final int MAPHEIGHT = 35;

    private GamePanel gameView;
    private MainMenuPanel mainMenuView;
    private GameOverPanel gameOverView;
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
     * Constructs a SailingGameApplication.
     */
    public SailingGameApplication() {
        super(new AppFrame(WINDOWWITH, WINDOWHEIGHT));
        this.gameView = new GamePanel(WINDOWWITH, WINDOWHEIGHT, MAPWIDTH, MAPHEIGHT, 16, 16);
        this.mainMenuView = new MainMenuPanel(WINDOWWITH, WINDOWHEIGHT);
        this.gameOverView = new GameOverPanel(WINDOWWITH, WINDOWHEIGHT);
    }

    /**
     * Main menu loop: Displays main menu and waits for user to press start game button
     * Game loop: Updates player position based on keyboard input, moves enemies, updates entity matrix.
     * Game over loop: Displays game over screen and waits for user to press back to menu button
     */
    @Override
    public void run() throws InterruptedException {
        this.gameView.setVisible(true);
        appWindow.setVisible(true);

        while (true) { 

            addViewToWindow(mainMenuView);

            /**
             * Main menu loop.
             */
            while (Thread.currentThread().isAlive()) {
                Thread.sleep(50);
                if (this.mainMenuView.getStartButtonPressed()) {
                    this.removeViewFromWindow(mainMenuView);
                    this.addViewToWindow(gameView);
                    this.mainMenuView.resetStartButtonPressed();
                    this.initializeGame();
                    break;
                }
            }

            /**
             * in-Game loop.
             */
            while (true) {
                Thread.sleep(75);
                if (this.enemyList.isEmpty()) {
                    this.waveNumber++;
                    this.enemyList.addAll(this.entitySpawner.createEnemyWave(this.waveNumber));
                    this.entityList.addAll(this.enemyList);
                    this.player.setHitPoints(100);
                }

                removeEntitiesWithZeroHp();

                updatePlayer();
                this.aiCommander.moveEnemies(this.enemyList);
                this.aiCommander.fireWeapons(this.enemyList);
                
                UProjectileUtility.moveProjectiles(this.entityList);
                UEntityMatrixGenerator.updateEntityMatrix(this.entityList);
                UProjectileUtility.checkProjectileCollisions(this.entityList, this.enemyList);
                UProjectileUtility.moveProjectiles(this.entityList);
                UEntityMatrixGenerator.updateEntityMatrix(this.entityList);
                UProjectileUtility.checkProjectileCollisions(this.entityList, this.enemyList);
                
                UProjectileUtility.updateProjectiles(this.entityList); 

                this.gameView.updateEntities(UEntityMatrixDecoder.decodeIntoIntMatrix(this.entityMatrix));
                
                // Game over
                if (this.player.getHitPoints() <= 0) {
                    this.waveNumber = 1;
                    this.removeViewFromWindow(gameView);
                    this.addViewToWindow(gameOverView);
                    this.gameOverView.setScoreLabel(ScoreBoard.getScore(player));
                    break;
                }
            }

            /**
             * Game over screen loop.
             */
            while (true) {
                Thread.sleep(50);
                if (this.gameOverView.getBackToMenuButtonPressed()) {
                    this.removeViewFromWindow(gameOverView);
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
        this.world = this.createWorld();
        this.entitySpawner = new EntitySpawner(this.world, new ShipBuilder());
        this.enemyList = this.entitySpawner.createEnemyWave(this.waveNumber);
        this.player = (CommandableEntity) this.entitySpawner.spawnPlayer();
        this.player.setHitPoints(100);
        this.entityList.add(player);
        this.entityList.addAll(this.enemyList);
        this.entityMatrix = UEntityMatrixGenerator.createEntityMatrix(MAPWIDTH, MAPHEIGHT,entityList);
        this.aiCommander = new AICommander(this.entityMatrix, this.world.getMap().getTileMatrix());
        UMovementUtility.setTileMatrix(this.world.getMap().getTileMatrix());
        UEntityCollisionUtility.setEntityMatrix(entityMatrix);
        this.gameView.updateTerrain((UTileMatrixDecoder.decodeIntoIntMatrix(world.getMap().getTileMatrix())));
        ScoreBoard.clearScoreBoard();
        ScoreBoard.addEntityToScoreBoard(this.player);
        ScoreBoard.setScore(this.player, 0);
        gameView.updateScore(ScoreBoard.getScore(player));
    }

    /**
     * Creates a basic world using the map and world generator. That being the random map generator.
     * @return A randomly generated world
     */
    private World createWorld() {
        IMapGenerator mapGenerator = new AdvancedMapGenerator();
        IWorldGenerator worldGenerator = new BasicWorldGenerator(mapGenerator);
        return worldGenerator.generateWorld(MAPWIDTH,MAPHEIGHT);
    }

    private void removeEntitiesWithZeroHp() {
        List<AEntity> entitiesToRemove = new ArrayList<>();
        for (AEntity entity : entityList) {
            if (entity.getHitPoints() <= 0 && !(entity instanceof ProjectileEntity)) {
                if (!entity.isFriendly()) {
                    ScoreBoard.incrementScore(player, waveNumber*10);
                    gameView.updateScore(ScoreBoard.getScore(player));
                }
                entitiesToRemove.add(entity);
            }
        }
        this.entityList.removeAll(entitiesToRemove);
        this.enemyList.removeAll(entitiesToRemove);
    }

    /**
     * Updates player position based on keyboard input
     */
    private void updatePlayer() {
        int movementInput = keyboardInterpreter.getMovementInput();
        int fireInput = keyboardInterpreter.getFireInput();
        gameView.updateHp((int) player.getHitPoints());

        if (movementInput >= 0) {
            this.player.moveIfPossible(movementInput);
        }
        if (fireInput >= 0) {
            this.player.attackIfPossible(fireInput);
        }
    }
}
