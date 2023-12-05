package com.group11.application;

import java.util.HashMap;

/**
 * The ScoreBoard class is responsible for keeping track of the score of entities. The class can map any object to an integer score.
 */
public final class ScoreBoard {
    
    private ScoreBoard() {
        throw new IllegalStateException("Utility class");
    }

    private static HashMap<Object, Integer> scoreMap = new HashMap<>();

    /**
     * Adds an entity to the score board.
     * @param entity the entity to be added
     */
    public static void addEntityToScoreBoard(Object gameEntity) {
        scoreMap.put(gameEntity, 0);
    }

    /**
     * Removes an entity from the score board.
     * @param entity the entity to be removed
     */
    public static void removeFromScoreBoard(Object gameEntity) {
        scoreMap.remove(gameEntity);
    }
    
    /**
     * Increments the score of an entity by a value.
     * @param entity the entity whose score is to be incremented
     * @param value the value by which the score is to be incremented
     */
    public static void incrementScore(Object gameEntity, int value) {
        scoreMap.put(gameEntity, scoreMap.get(gameEntity) + value);
    }

    /**
     * Returns the score of an entity.
     * @param entity the entity whose score is to be returned
     * @return the score of the entity
     */
    public static int getScore(Object gameEntity) {
        return scoreMap.get(gameEntity);
    }

    /**
     * Sets the score of an entity to a value.
     * @param entity the entity whose score is to be set
     * @param value the value to which the score is to be set
     */
    public static void setScore(Object gameEntity, int value) {
        scoreMap.put(gameEntity, value);
    }

    /**
     * Clears the score map.
     */
    public static void clearScoreBoard() {
        scoreMap.clear();
    }
    
}
