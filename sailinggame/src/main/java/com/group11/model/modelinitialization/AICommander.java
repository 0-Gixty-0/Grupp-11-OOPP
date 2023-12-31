package com.group11.model.modelinitialization;

import java.awt.Point;
import java.time.temporal.ValueRange;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.group11.model.gameentites.AEntity;
import com.group11.model.gameentites.CommandableEntity;
import com.group11.model.utility.UAStar;
import com.group11.model.utility.UViewTileMatrixDecoder;

/**
 * Class representing controller for CommandableEntities that aren't controlled by the player.
 */
public class AICommander {

    private Random random = new Random();
    protected int innerRadius = 5;
    private List<List<AEntity>> entityMatrix;
    private List<List<Integer>> terrainMatrixEncoded;
    private final int[][] directions = {{-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}};

    public AICommander(List<List<AEntity>> entityMatrix) {
        this.entityMatrix = entityMatrix;
        this.terrainMatrixEncoded = UViewTileMatrixDecoder.decodeIntoIntMatrix();
    }

    /**
     * Sets the current entity matrix
     *
     * @param entityMatrix The desired entity matrix
     */
    public void setEntityMatrix(List<List<AEntity>> entityMatrix) {
        this.entityMatrix = entityMatrix;
    }

    /**
     * Sets the current encoded terrain matrix through the object terrain matrix
     */
    public void updateTerrainMatrixEncoded() {
        this.terrainMatrixEncoded = UViewTileMatrixDecoder.decodeIntoIntMatrix();
    }

    /**
     * This method moves the enemies in the input list based on their proximity to the player.
     * If the enemy is within the class specified radius, the method runs an AStar search from the enemy
     * to the player and moves the enemy one step closer in the shortest path direction to the player.
     * If the player has the enemy within a specified radius, then the enemy will choose a random directional value
     * If the player is not in proximity, then a random directional value is selected
     *
     * @param enemies The list of enemies to move
     */
    public void moveEnemies(List<CommandableEntity> enemies) {
        
        for (CommandableEntity enemy : enemies) {
            int entityRowIndex = enemy.getPos().x;
            int entityColumnIndex = enemy.getPos().y;
            HashMap<String, Point> namePosMap = this.getSurroundingEntityNameAndPos(entityRowIndex, entityColumnIndex, 10);
            if (namePosMap.containsKey("Player")) {
                Point playerPoint = namePosMap.get("Player");
                Point enemyPoint = enemy.getPos();
                if (!this.isNearEnemy(playerPoint, this.innerRadius)) {
                    int directionToPlayer = UAStar.aStar(this.terrainMatrixEncoded, enemyPoint.x, enemyPoint.y, playerPoint.x, playerPoint.y);
                    enemy.moveIfPossible(directionToPlayer);
                } else {
                    enemy.moveIfPossible(random.nextInt(8));
                }
            } else {
                enemy.moveIfPossible(random.nextInt(8));
            }
        }
    }

    /**
     * Helper method checking if the input entity is in proximity to an enemy
     *
     * @param entityPos The position to center the proximity search
     * @return True: Enemy is near, False: Enemy is not near
     */
    private boolean isNearEnemy(Point entityPos, int radius) {
        int entityRowIndex = entityPos.x;
        int entityColumnIndex = entityPos.y;
        HashMap<String, Point> surroundingEntities = this.getSurroundingEntityNameAndPos(entityRowIndex, entityColumnIndex, radius);
        return (surroundingEntities.containsKey("Enemy"));
    }

    /**
     * Gets the surrounding entities and their respective positions centered from input position.
     * Searches in a box radius around the center with side length specified through radius attribute
     *
     * @param row Row index of the center
     * @param col Column index of the center
     * @return HashMap with keys as entity names and values as entity positions
     */
    private HashMap<String, Point> getSurroundingEntityNameAndPos(int row, int col, int radius) {
        HashMap<String, Point> surroundingElements = new HashMap<>();

        int mapHeight = this.entityMatrix.size();
        int mapWidth = this.entityMatrix.get(0).size();

        // Check bounds and add surrounding elements within the given radius
        for (int i = row - radius; i <= row + radius; i++) {
            for (int j = col - radius; j <= col + radius; j++) {
                if (i >= 0 && 
                    i < mapHeight &&
                    j >= 0 && 
                    j < mapWidth &&
                    !(i == row && j == col) &&
                    (this.entityMatrix.get(i).get(j) != null)) {

                    String name = this.entityMatrix.get(i).get(j).getName();
                    Point position = this.entityMatrix.get(i).get(j).getPos();
                    surroundingElements.put(name, position);
                    
                }
            }
        }
        return surroundingElements;
    }

    /**
     * Method checks if two points are nearly equal defined by if dx is within -1 - 1 or dy is within -1 - 1
     * If the above is true then returns true else false.
     *
     * @param p1 First point
     * @param p2 Second point
     * @return True: dx or dy within range -1 - 1, False: dx or dy not within range -1 - 1
     */
    private boolean isNearlyEqual(Point p1, Point p2) {
        ValueRange range = ValueRange.of(-1, 1);
        return (range.isValidIntValue(p2.x - p1.x) || range.isValidIntValue(p2.y - p1.y));
    }

    /**
     * This method checks if the path between two points is clear. That meaning there are no impassable terrain between
     * the two locations in the direction given as parameter
     *
     * @param direction The direction to move the path in
     * @param start The start point
     * @param goal The end point
     * @return True: A clear path exists, False: A clear path does not exist
     */
    private boolean isPathClear(int[] direction, Point start, Point goal) {
        while (!this.isNearlyEqual(start, goal)) {
            Point newPos = new Point(start.x + direction[0], start.y + direction[1]);
            if (this.terrainMatrixEncoded.get(newPos.x).get(newPos.y) == 0) {
                return false;
            } else {
                start = new Point(newPos);
            }
        }
        return true;
    }

    /**
     * This method fires the weapons of the entities that are passed as parameter.
     * It checks if the entity is within a range of the player and then checks if the projectile
     * path is clear from impassable terrain. If the above is true then the entity will attack in the direction of the player
     *
     * @param entities The list of entities to issue fire commands for at the player
     */
    public void fireWeapons(List<CommandableEntity> entities) {
        for (CommandableEntity entity : entities) {
            int entityRowIndex = entity.getPos().x;
            int entityColumnIndex = entity.getPos().y;
            HashMap<String, Point> namePosMap = this.getSurroundingEntityNameAndPos(entityRowIndex, entityColumnIndex, 15);
            if (namePosMap.containsKey("Player")) {
                Point playerPoint = namePosMap.get("Player");
                Point enemyPoint = entity.getPos();
                int dx = playerPoint.x - enemyPoint.x;
                int dy = playerPoint.y - enemyPoint.y;
                int fireDirection = UAStar.getDirection(dx,dy);
                if (this.isPathClear(this.directions[fireDirection], enemyPoint, playerPoint)) {
                    entity.attackIfPossible(fireDirection);
                }
            }
        }
    }
}