package com.group11.model;

import java.awt.*;
import java.util.ArrayList;

/**
 * Class representing a factory for creating standard movable entities
 */
public class StandardMovableEntityFactory implements IMovableEntityFactory {
    /**
     * Creates a movable entity of type AEntity representing a standard player.
     * The method creates a body of type Ship for the entity and a starting position for the ship.
     * @return Object of type AEntity including a body and position
     */
    public AEntity createPlayer() {
        return new CommandableEntity(new Ship(new Point(0,0)), "player", true);
    }

    /**
     * Creates a movable entity of type AEntity representing a standard enemy.
     * The method creates a body of type Ship for the entity and a starting position for the ship.
     * @return Object of type AEntity including a body and position
     */
    public AEntity createEnemy() {
        // TODO
        // Create an unplayable entity class
        return null;
    }

    /**
     * Method creating the dimensions parameter for a Ship from a set size where matrix is (size x size)
     * @param size Size of square matrix
     * @return Square matrix of size (size) containing all true values
     */
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
