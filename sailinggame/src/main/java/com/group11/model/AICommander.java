package com.group11.model;


import com.group11.model.gameentites.AEntity;
import com.group11.model.gameentites.CommandableEntity;
import com.group11.model.gameworld.ATile;
import com.group11.model.utility.TileMatrixDecoder;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class AICommander {
    private final int radius = 10;
    private ArrayList<ArrayList<AEntity>> entityMatrix;
    private List<List<Integer>> terrainMatrixEncoded;

    public AICommander(ArrayList<ArrayList<AEntity>> entityMatrix, List<List<ATile>> terrainMatrix) {
        this.entityMatrix = entityMatrix;
        this.terrainMatrixEncoded = TileMatrixDecoder.decodeIntoIntMatrix(terrainMatrix);
    }

    public void setEntityMatrix(ArrayList<ArrayList<AEntity>> entityMatrix) {
        this.entityMatrix = entityMatrix;
    }
    public void setTerrainMatrixEncoded(List<List<ATile>> terrainMatrix) {
        this.terrainMatrixEncoded = TileMatrixDecoder.decodeIntoIntMatrix(terrainMatrix);
    }

    public void moveEnemies(ArrayList<CommandableEntity> enemies) {
        Random random = new Random();
        for (CommandableEntity enemy : enemies) {
            int entityRowIndex = enemy.getBody().getPos().x;
            int entityColumnIndex = enemy.getBody().getPos().y;
            HashMap<String, Point> namePosMap = this.getSurroundingEntityNameAndPos(entityRowIndex, entityColumnIndex);
            if (namePosMap.containsKey("Player")) {
                Point playerPoint = namePosMap.get("Player");
                Point enemyPoint = enemy.getPos();
                int directionToPlayer = AStar.aStar(this.terrainMatrixEncoded, enemyPoint.x, enemyPoint.y, playerPoint.x, playerPoint.y);
                enemy.moveCommand(directionToPlayer);
            } else {
                enemy.moveCommand(random.nextInt(8));
            }
        }
    }

    private boolean isNearPlayer(CommandableEntity entity, ArrayList<ArrayList<AEntity>> entityMatrix) {
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
