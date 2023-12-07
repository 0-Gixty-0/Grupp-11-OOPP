package com.group11.application;

import java.util.ArrayList;
import java.util.List;

import com.group11.controller.KeyboardInterpretor;
import com.group11.model.builders.ShipBuilder;
import com.group11.model.gameentites.AEntity;
import com.group11.model.gameentites.AProjectile;
import com.group11.model.gameentites.AWeapon;
import com.group11.model.gameentites.CommandableEntity;
import com.group11.model.gameentites.IHasWeapon;
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
    public SailingGameApplication(int windowWidth, int windowHeight, int mapWidth, int mapHeight) {
        super(new AppFrame(windowWidth, windowHeight));
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.gameView = new GamePanel(windowWidth, windowHeight, mapWidth, mapHeight, 16, 16);
        this.mainMenuView = new MainMenuPanel(windowWidth, windowHeight);
        this.gameOverView = new GameOverPanel(windowWidth, windowHeight);
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
                    this.gameView.updateTerrain((UTileMatrixDecoder.decodeIntoIntMatrix(world.getMap().getTileMatrix())));
                    this.gameView.updateEntities(UEntityMatrixDecoder.decodeIntoIntMatrix(this.entityMatrix));
                    break;
                }
            }

            while (true) { // Game loop
                if (this.enemyList.isEmpty()) {
                    this.waveNumber++;
                    this.enemyList.addAll(this.entitySpawner.createEnemyWave(this.waveNumber));
                    this.entityList.addAll(this.enemyList);
                }
                this.aiCommander.moveEnemies(this.enemyList);
                this.aiCommander.fireWeapons(this.enemyList);
                updateProjectiles();
                checkProjectileCollisions();
                updatePlayer();
                updateEntityMatrix();
                Thread.sleep(50);

                if (this.player.getBody().getHitPoints() <= 0) { // Game over
                    this.removeViewFromWindow(gameView);
                    this.addViewToWindow(gameOverView);
                    this.gameOverView.setScoreLabel(0);
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
        this.entityMatrix = UEntityMatrixGenerator.createEntityMatrix(this.mapWidth, this.mapHeight);
        this.aiCommander = new AICommander(this.entityMatrix, this.world.getMap().getTileMatrix());
        this.enemyList = this.entitySpawner.createEnemyWave(this.waveNumber);
        this.player = this.createPlayer();
        this.entityList.add(player);
        this.entityList.addAll(this.enemyList);
        UEntityMatrixGenerator.populateEntityMatrix(this.entityList, this.entityMatrix);
        UMovementUtility.setTileMatrix(this.world.getMap().getTileMatrix());
        UEntityCollisionUtility.setBodyMatrix(entityMatrix);
    }

    /**
     * Creates a basic world using the map and world generator. That being the random map generator.
     * @return A randomly generated world
     */
    private World createWorld() {
        IMapGenerator mapGenerator = new AdvancedMapGenerator();
        IWorldGenerator worldGenerator = new BasicWorldGenerator(mapGenerator);
        return worldGenerator.generateWorld(this.mapWidth,this.mapHeight);
    }

    /**
     * Creates the basic version of a player using the entity spawner
     * @return The model representation of a player
     */
    private CommandableEntity createPlayer() {
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
        UEntityCollisionUtility.setBodyMatrix(entityMatrix);
    }

    private class ProjectileEntiy extends AEntity {

        public ProjectileEntiy(AProjectile body, String name, Boolean friendly) {
            super(body, name, friendly);
        }

        public AProjectile getBody() {
            return (AProjectile) super.getBody();
        }
    }

    private void updateProjectiles() {

        List<AEntity> entitiesToRemove = new ArrayList<>();
        List<AProjectile> projectilesToRemove = new ArrayList<>();

        for (AEntity entity : this.entityList) {
            if (entity.getBody() instanceof IHasWeapon) {
               AWeapon weapon = ((IHasWeapon) entity.getBody()).getWeapon();
                List<AProjectile> firedProjectiles = weapon.getFiredProjectiles();
                for (AProjectile projectile : firedProjectiles) {
                    if (projectile.isOutOfRange()) {
                        projectilesToRemove.add(projectile);
                    }
                }
                firedProjectiles.removeAll(projectilesToRemove);
            }
            if (entity.getBody() instanceof AProjectile) {
                ((AProjectile) entity.getBody()).travel();
                if (((AProjectile) entity.getBody()).isOutOfRange()) {
                    entitiesToRemove.add(entity);
                }
            }
        }

        this.entityList.removeAll(entitiesToRemove);
    
    }

    private void checkProjectileCollisions() {
        List<AEntity> entitiesToRemove = new ArrayList<>();
        for (AEntity entity : this.entityList) {
            AEntity collidingEntity = UEntityCollisionUtility.isEntityColliding(entity);
            if (collidingEntity != null && collidingEntity.getBody() instanceof AProjectile)  {
                int damage = ((AProjectile) collidingEntity.getBody()).getDamage();
                entity.getBody().takeDamage(damage);
                if (entity.getBody().getHitPoints() <= 0) {
                    entitiesToRemove.add(entity);
                }
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

        if (movementInput >= 0) {
            this.player.moveIfAble(movementInput);
        }
        if (fireInput >= 0) {
            this.player.attackIfAble(fireInput);
            IHasWeapon playerBody = (IHasWeapon) this.player.getBody();
            AWeapon weapon = playerBody.getWeapon();
            List<AProjectile> firedProjectiles = weapon.getFiredProjectiles();
            for (AProjectile projectile : firedProjectiles) {
                AEntity projectileEntity = new ProjectileEntiy(projectile, "CannonBall", true);
                this.entityList.add(projectileEntity);
            }
            gameView.updateHp((int) player.getBody().getHitPoints());
        }
    }
}
