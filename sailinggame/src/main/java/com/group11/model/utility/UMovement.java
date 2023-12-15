package com.group11.model.utility;

import java.awt.Point;
import java.util.List;

import com.group11.model.gameworld.ATile;

/**
 * Utility class for checking if movement is possible.
 */
public final class UMovement {

    /**
     * Matrix of ATiles to check for collision.
     */
    private static List<List<ATile>> tileMatrix;

    private UMovement() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Set the tileMatrix to be used for checking if movement is possible.
     * @param tileMatrix
     */
    public static void setTileMatrix(List<List<ATile>> tileMatrix) {
        UMovement.tileMatrix = tileMatrix;
    }

    /**
     * Check if movement is possible in a given direction.
     *
     * @param currPos Current position of the body.
     * @param dirVector Direction vector of the movement.
     * @return (Boolean) true if movement is possible, false otherwise.
     */
    public static Boolean movementIsPossible(Point currPos, int[] dirVector) {

        if (UMovement.tileMatrix == null) {
            throw new IllegalStateException("Unable to move because a tileMatrix has not been set for MovementUtility");
        }

        int newX = (int) currPos.getX() + dirVector[0];
        int newY = (int) currPos.getY() + dirVector[1];

        try {
            //Trying to move over impassable terrain
            return (UMovement.tileMatrix.get(newX).get(newY).isPassable());
            //Trying to move outside the world
        } catch (IndexOutOfBoundsException e) {
            return false; 
        }
    }
}