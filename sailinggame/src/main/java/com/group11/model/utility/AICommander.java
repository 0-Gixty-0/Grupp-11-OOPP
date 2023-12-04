package com.group11.model.utility;


import com.group11.model.gameentites.AEntity;
import com.group11.model.gameentites.CommandableEntity;
import com.group11.model.gameworld.ATile;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Class representing controller for AI controlled entities
 */
public class AICommander {
    private final int radius = 10;
    private List<List<AEntity>> entityMatrix;
    private List<List<Integer>> terrainMatrixEncoded;

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
            HashMap<String, Point> namePosMap = this.getSurroundingEntityNameAndPos(entityRowIndex, entityColumnIndex);
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
     * @param entityMatrix The entity matrix to search in
     * @return True: Player is near, False: Player is not near
     */
    private boolean isNearPlayer(CommandableEntity entity, List<List<AEntity>> entityMatrix) {
        int entityRowIndex = entity.getBody().getPos().y;
        int entityColumnIndex = entity.getBody().getPos().x;
        int radius = 5;
        HashMap<String, Point> surroundingEntities = this.getSurroundingEntityNameAndPos(entityRowIndex, entityColumnIndex);
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
    private HashMap<String, Point> getSurroundingEntityNameAndPos(int row, int col) {
        HashMap<String, Point> surroundingElements = new HashMap<>();

        int n = this.entityMatrix.size();

        // Check bounds and add surrounding elements within the given radius
        for (int i = row - this.radius; i <= row + this.radius; i++) {
            for (int j = col - this.radius; j <= col + this.radius; j++) {
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
}
