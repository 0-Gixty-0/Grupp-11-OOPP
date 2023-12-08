package com.group11.application;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.group11.controller.KeyboardInterpretor;
import com.group11.model.builders.ShipBuilder;
import com.group11.model.gameentites.AEntity;
import com.group11.model.gameentites.CommandableEntity;
import com.group11.model.gameentites.IHasWeapon;
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

            while (Thread.currentThread().isAlive()) {
                Thread.sleep(50);
                if (this.mainMenuView.getStartButtonPressed()) { // Main menu loop
                    this.removeViewFromWindow(mainMenuView);
                    this.addViewToWindow(gameView);
                    this.mainMenuView.resetStartButtonPressed();
                    this.initializeGame();
                    break;
                }
            }

            while (true) { // Game loop
                Thread.sleep(50);
                if (this.enemyList.isEmpty()) {
                    this.waveNumber++;
                    this.enemyList.addAll(this.entitySpawner.createEnemyWave(this.waveNumber));
                    this.entityList.addAll(this.enemyList);
                    this.player.setHitPoints(100);
                }
                updatePlayer();
                this.aiCommander.moveEnemies(this.enemyList);
                this.aiCommander.fireWeapons(this.enemyList);
                updateProjectiles();
                moveProjectiles();
                moveProjectiles();
                updateEntityMatrix();
                checkProjectileCollisions();
                
                if (this.player.getHitPoints() <= 0) { // Game over
                    this.waveNumber = 1;
                    this.removeViewFromWindow(gameView);
                    this.addViewToWindow(gameOverView);
                    this.gameOverView.setScoreLabel(ScoreBoard.getScore(player));
                    break;
                }
            }

            while (true) { // Game over loop
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
        this.entityMatrix = UEntityMatrixGenerator.createEntityMatrix(MAPWIDTH, MAPHEIGHT);
        this.aiCommander = new AICommander(this.entityMatrix, this.world.getMap().getTileMatrix());
        this.enemyList = this.entitySpawner.createEnemyWave(this.waveNumber);
        this.player = (CommandableEntity) this.entitySpawner.spawnPlayer();
        this.player.setHitPoints(100);
        this.entityList.add(player);
        this.entityList.addAll(this.enemyList);
        UEntityMatrixGenerator.populateEntityMatrix(this.entityList, this.entityMatrix);
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

    /**
     * Updates the entity matrix from the entity list and updates the visual representation of entities in the frame
     */
    private void updateEntityMatrix() {
        this.entityMatrix = UEntityMatrixGenerator.createEntityMatrix(MAPWIDTH, MAPHEIGHT);
        UEntityMatrixGenerator.populateEntityMatrix(this.entityList, this.entityMatrix);
        this.aiCommander.setEntityMatrix(this.entityMatrix);
        this.gameView.updateEntities(UEntityMatrixDecoder.decodeIntoIntMatrix(this.entityMatrix));
        UEntityCollisionUtility.setEntityMatrix(entityMatrix);
    }

    /**
     * Checks if any projectiles are colliding with any entities and deals damage to the entity if so
     */
    private void checkProjectileCollisions() {
        
        for (AEntity entity : this.entityList) {
            AEntity collidingEntity = UEntityCollisionUtility.isEntityColliding(entity);
            if (collidingEntity != null && collidingEntity instanceof ProjectileEntity)  {
                entity.takeDamage(((ProjectileEntity) collidingEntity).getDamage());
                if (entity.getHitPoints() <= 0 && !entity.isFriendly()) {
                    ScoreBoard.incrementScore(player, waveNumber*10);
                    gameView.updateScore(ScoreBoard.getScore(player));
                }
            }
        }
        this.entityList.removeIf(e -> e.getHitPoints() <= 0);
        this.enemyList.removeIf(e -> e.getHitPoints() <= 0);
    }

    /**
     * Creates a list of projectiles from the entity list
     */
    private void updateProjectiles() {
        List<AEntity> projectiles = new ArrayList<>();
        for (AEntity entity : this.entityList) {
            if (entity.getBody() instanceof IHasWeapon) {
                ((IHasWeapon) entity.getBody()).getWeapon().removeOutOfRangeProjectiles();
                projectiles.addAll(((IHasWeapon) entity.getBody()).getWeapon().getFiredProjectiles());
            }
        }
        entityList.removeIf(e -> e instanceof ProjectileEntity && ((ProjectileEntity) e).isOutOfRange());
        entityList.addAll(projectiles);
    }

    /**
     * Moves all projectiles in the entity list
     */
    private void moveProjectiles() {
        for (AEntity entity : this.entityList) {
            if (entity instanceof ProjectileEntity) {
                ((ProjectileEntity) entity).moveInTravelPath();
            }
        }
    }

    /**
     * Updates player position based on keyboard input
     */
    private void updatePlayer() {
        int movementInput = keyboardInterpreter.getMovementInput();
        int fireInput = keyboardInterpreter.getFireInput();
        gameView.updateHp((int) player.getHitPoints());

        if (movementInput >= 0) {
            this.player.moveIfAble(movementInput);
        }
        if (fireInput >= 0) {
            this.player.attackIfAble(fireInput);
        }
    }
}
