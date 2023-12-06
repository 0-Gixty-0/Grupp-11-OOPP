package com.group11.model.utility;


import java.awt.Point;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.group11.model.gameentites.AEntity;
import com.group11.model.gameentites.CommandableEntity;
import com.group11.model.gameworld.ATile;

/**
 * Class representing controller for AI controlled entities
 */
public class AICommander {
    private final int radius = 10;
    private List<List<AEntity>> entityMatrix;
    private List<List<Integer>> terrainMatrixEncoded;
    private final int[][] directions = {{-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}};

    public AICommander(List<List<AEntity>> entityMatrix, List<List<ATile>> terrainMatrix) {
        this.entityMatrix = entityMatrix;
        this.terrainMatrixEncoded = UTileMatrixDecoder.decodeIntoIntMatrix(terrainMatrix);
    }

    /**
     * Sets the current entity matrix
     * @param entityMatrix The desired entity matrix
     */
    public void setEntityMatrix(List<List<AEntity>> entityMatrix) {
        this.entityMatrix = entityMatrix;
    }

    /**
     * Sets the current encoded terrain matrix through the object terrain matrix
     * @param terrainMatrix The object terrain matrix to set as encoded
     */
    public void setTerrainMatrixEncoded(List<List<ATile>> terrainMatrix) {
        this.terrainMatrixEncoded = UTileMatrixDecoder.decodeIntoIntMatrix(terrainMatrix);
    }

    /**
     * This method moves the enemies in the input list based on their proximity to the player.
     * If the enemy is within the class specified radius the method runs an AStar search from the enemy
     * to the player and moves the enemy one step closer in the shortest path direction to the player.
     * If the player is not in proximity than a random directional value is selected
     * @param enemies The list of enemies to move
     */
    public void moveEnemies(List<CommandableEntity> enemies) {
        Random random = new Random();
        for (CommandableEntity enemy : enemies) {
            int entityRowIndex = enemy.getBody().getPos().x;
            int entityColumnIndex = enemy.getBody().getPos().y;
            HashMap<String, Point> namePosMap = this.getSurroundingEntityNameAndPos(entityRowIndex, entityColumnIndex, 10);
            if (namePosMap.containsKey("Player")) {
                Point playerPoint = namePosMap.get("Player");
                Point enemyPoint = enemy.getPos();
                int directionToPlayer = AStar.aStar(this.terrainMatrixEncoded, enemyPoint.x, enemyPoint.y, playerPoint.x, playerPoint.y);
                enemy.moveIfAble(directionToPlayer);
            } else {
                enemy.moveIfAble(random.nextInt(8));
            }
        }
    }

    /**
     * Helper method checking if the input entity is in proximity to the player
     * @param entity The entity to center the proximity search
     * @return True: Player is near, False: Player is not near
     */
    private boolean isNearPlayer(CommandableEntity entity, int radius) {
        int entityRowIndex = entity.getBody().getPos().y;
        int entityColumnIndex = entity.getBody().getPos().x;
        HashMap<String, Point> surroundingEntities = this.getSurroundingEntityNameAndPos(entityRowIndex, entityColumnIndex, radius);
        if (surroundingEntities.containsKey("Player")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gets the surrounding entities and their respective positions centered from input position.
     * Searches in a box radius around the center with side length specified through radius attribute
     * @param row Row index of center
     * @param col Column index of center
     * @return HashMap with keys as entity names and values as entity positions
     */
    private HashMap<String, Point> getSurroundingEntityNameAndPos(int row, int col, int radius) {
        HashMap<String, Point> surroundingElements = new HashMap<>();

        int n = this.entityMatrix.size();

        // Check bounds and add surrounding elements within the given radius
        for (int i = row - radius; i <= row + radius; i++) {
            for (int j = col - radius; j <= col + radius; j++) {
                if (i >= 0 && i < n && j >= 0 && j < n && !(i == row && j == col)) {
                    if (this.entityMatrix.get(i).get(j) != null) {
                        String name = this.entityMatrix.get(i).get(j).getName();
                        Point position = this.entityMatrix.get(i).get(j).getBody().getPos();
                        surroundingElements.put(name, position);
                    }
                }
            }
        }
        return surroundingElements;
    }

    private boolean isPathClear(int[] direction, Point start, Point goal) {
        while (start != goal) {
            Point newPos = new Point(start.x + direction[0], start.y + direction[1]);
            if (this.terrainMatrixEncoded.get(newPos.x).get(newPos.y) == 0) {
                return false;
            } else {
                start.setLocation(newPos);
            }
        }
        return true;
    }

    public void fireWeapons(List<CommandableEntity> entities) {
        for (CommandableEntity entity : entities) {
            int entityRowIndex = entity.getBody().getPos().x;
            int entityColumnIndex = entity.getBody().getPos().y;
            HashMap<String, Point> namePosMap = this.getSurroundingEntityNameAndPos(entityRowIndex, entityColumnIndex, 15);
            if (namePosMap.containsKey("Player")) {
                Point playerPoint = namePosMap.get("Player");
                Point enemyPoint = entity.getPos();
                int dx = playerPoint.x - enemyPoint.x;
                int dy = playerPoint.y - enemyPoint.y;
                int fireDirection = AStar.getDirection(dx,dy);
                if (this.isPathClear(this.directions[fireDirection], enemyPoint, playerPoint)) {
                    entity.attackIfAble(fireDirection);
                }
            }
        }
    }
}