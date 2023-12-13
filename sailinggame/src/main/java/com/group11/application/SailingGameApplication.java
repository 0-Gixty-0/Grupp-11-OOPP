package com.group11.application;

import java.util.ArrayList;
import java.util.List;

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
import com.group11.model.utility.EntitySpawner;
import com.group11.model.utility.UEntityCollisionUtility;
import com.group11.model.utility.UEntityMatrixDecoder;
import com.group11.model.utility.UEntityMatrixGenerator;
import com.group11.model.utility.UMovementUtility;
import com.group11.model.utility.UProjectileUtility;
import com.group11.model.utility.UTileMatrixDecoder;
import com.group11.view.uicomponents.AppFrame;

/**
 * A class containing logic specific to the SailingGame application. The idea of our project was to make the source
 * code as extendable as possibile, therefore if you wanted to create a new game you would only need to change this class.
 */
public class SailingGameApplication extends AApplication {

    private static final int WINDOWWITH = 1100;
    private static final int WINDOWHEIGHT = 1000;
    private static final int MAPWIDTH = 65;
    private static final int MAPHEIGHT = 30;

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
        super(new AppFrame(WINDOWWITH, WINDOWHEIGHT, MAPWIDTH, MAPHEIGHT, 16, 16));
    }

    /**
     * Initializes the game upon pressing start game button by creating the player and spawning a level one wave
     * of enemies. It then adds these entities to the entity list and creates the entity matrix
     */
    private void initializeGame() {
        this.waveNumber = 1;
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
        this.appWindow.updateTerrain((UTileMatrixDecoder.decodeIntoIntMatrix(world.getMap().getTileMatrix())));
        ScoreBoard.clearScoreBoard();
        ScoreBoard.addEntityToScoreBoard(this.player);
        ScoreBoard.setScore(this.player, 0);
        this.appWindow.updateScore(ScoreBoard.getScore(player));
    }

    /**
     * Main menu loop: Displays main menu and waits for user to press start game button
     * Game loop: Updates player position based on keyboard input, moves enemies, updates entity matrix.
     * Game over loop: Displays game over screen and waits for user to press back to menu button
     * @param cycleSpeedMS The time (in milli seconds) that the application sleeps inbetween every cycle.
     */
    @Override
    public void run(int cyclespeedMS) throws InterruptedException {
        
        appWindow.setVisible(true);

        while (true) { 

            this.appWindow.displayMainMenuView();

            /**
             * Main menu loop.
             */
            while (Thread.currentThread().isAlive()) {
                Thread.sleep(cyclespeedMS);
                if (this.appWindow.getStartButtonPressed()) {
                    this.appWindow.displayGameView();
                    this.initializeGame();
                    break;
                }
            }

            /**
             * in-Game loop.
             */
            while (Thread.currentThread().isAlive()) {
                Thread.sleep(cyclespeedMS);
                if (this.enemyList.isEmpty()) {
                    this.waveNumber++;
                    this.enemyList.addAll(this.entitySpawner.createEnemyWave(this.waveNumber));
                    this.entityList.addAll(this.enemyList);
                    this.player.setHitPoints(100);
                }

                updatePlayer();
                this.aiCommander.moveEnemies(this.enemyList);
                this.aiCommander.fireWeapons(this.enemyList);

                UProjectileUtility.updateProjectiles(this.entityList); // Adds new projectiles to entity list and removes old dead projectiles.

                UProjectileUtility.moveProjectiles(this.entityList); // Moves the projectiles.
                UEntityMatrixGenerator.updateEntityMatrix(this.entityList); // Updates the entity matrix.
                UProjectileUtility.checkProjectileCollisions(this.entityList); // Checks for collisions.
                // Two iterations so that projectiles moves faster than other entities.
                UProjectileUtility.moveProjectiles(this.entityList);
                UEntityMatrixGenerator.updateEntityMatrix(this.entityList);
                UProjectileUtility.checkProjectileCollisions(this.entityList);
                // Updating the view.
                this.appWindow.updateEntities(UEntityMatrixDecoder.decodeIntoIntMatrix(this.entityMatrix));

                // Removes dead entities
                removeEntitiesWithZeroHp();

                // Game over
                if (this.player.getHitPoints() <= 0) {
                    this.appWindow.displayGameOverView();
                    break;
                }
            }

            /**
             * Game over screen loop.
             */
            while (Thread.currentThread().isAlive()) {
                Thread.sleep(cyclespeedMS);
                if (this.appWindow.getBackToMenuButtonPressed()) {
                    break;
                }
            }
        }
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
     * Removes entities that are dead (0 hp or lower)
     */
    private void removeEntitiesWithZeroHp() {
        List<AEntity> entitiesToRemove = new ArrayList<>();
        for (AEntity entity : entityList) {
            if (entity.getHitPoints() <= 0) {
                if (!entity.isFriendly()) {
                    ScoreBoard.incrementScore(player, waveNumber*10);
                    this.appWindow.updateScore(ScoreBoard.getScore(player));
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
        this.appWindow.updateHp(player.getHitPoints());

        if (movementInput >= 0) {
            this.player.moveIfPossible(movementInput);
        }
        if (fireInput >= 0) {
            this.player.attackIfPossible(fireInput);
        }
    }
}
