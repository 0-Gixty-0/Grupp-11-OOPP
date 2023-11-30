package com.group11.model;


import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AICommander {
    private ArrayList<ArrayList<AEntity>> entityMatrix;
    private List<List<Integer>> terrainMatrixEncoded;

    public AICommander(ArrayList<ArrayList<AEntity>> entityMatrix, List<List<ATile>> terrainMatrix) {
        this.entityMatrix = entityMatrix;
        this.terrainMatrixEncoded = TileMatrixDecoder.decodeIntoIntMatrix(terrainMatrix);
    }

    public void setEntityMatrix(ArrayList<ArrayList<AEntity>> entityMatrix) {
        this.entityMatrix = entityMatrix;
    }

    public void moveEnemies(ArrayList<CommandableEntity> enemies) {
        for (CommandableEntity enemy : enemies) {
            int entityRowIndex = enemy.getBody().getPos().y;
            int entityColumnIndex = enemy.getBody().getPos().x;
            int radius = 5;
            HashMap<String, Point> namePosMap = this.getSurroundingEntityNameAndPos(entityRowIndex, entityColumnIndex, radius);
            if (namePosMap.containsKey("Player")) {
                Point playerPoint = namePosMap.get("Player");
                Point enemyPoint = enemy.getPos();
                int
                int directionToPlayer = AStar.aStar()
            }
        }
    }

    private boolean isNearPlayer(CommandableEntity entity, ArrayList<ArrayList<AEntity>> entityMatrix) {
        int entityRowIndex = entity.getBody().getPos().y;
        int entityColumnIndex = entity.getBody().getPos().x;
        int radius = 5;
        HashMap<String, Point> surroundingEntities = this.getSurroundingEntityNameAndPos(entityRowIndex, entityColumnIndex, radius);
        if (surroundingEntities.containsKey("Player")) {
            return true;
        } else {
            return false;
        }
    }

    private HashMap<String, Point> getSurroundingEntityNameAndPos(int row, int col, int radius) {
        HashMap<String, Point> surroundingElements = new HashMap<>();

        int n = this.entityMatrix.size();

        // Check bounds and add surrounding elements within the given radius
        for (int i = row - radius; i <= row + radius; i++) {
            for (int j = col - radius; j <= col + radius; j++) {
                if (i >= 0 && i < n && j >= 0 && j < n && !(i == row && j == col)) {
                    String name = this.entityMatrix.get(i).get(j).getName();
                    Point position = this.entityMatrix.get(i).get(j).getBody().getPos();
                    surroundingElements.put(name, position);
                }
            }
        }
        return surroundingElements;
    }
}
