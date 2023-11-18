package com.group11.model;

import java.awt.*;
import java.util.ArrayList;

public class StandardMovableEntityFactory implements IMovableEntityFactory {
    public AEntity createPlayer() {
        ArrayList<ArrayList<Boolean>> dimensions = createDimensions(1);
        return new PlayableEntity(new Ship(dimensions, new Point(0,0), 0, 0 ,0 ,0, 0), "player");
    }

    public AEntity createEnemy() {
        // TODO
        // Create an unplayable entity class
        return null;
    }

    private ArrayList<ArrayList<Boolean>> createDimensions(int size) {
        ArrayList<ArrayList<Boolean>> dimensions = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            ArrayList<Boolean> row = new ArrayList<>();
            for (int j = 1; j <= size; j++) {
                row.add(true);
            }
            dimensions.add(row);
        }
        return dimensions;
    }
}
