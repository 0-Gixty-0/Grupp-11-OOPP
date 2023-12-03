package com.group11.model.gameworld;

import java.util.List;

/**
 * Map is a representation of a two-dimensional physical map in the form of an object containing Matrix's.
 */
public class Map {

    private List<List<ATile>> tileMatrix;
    private int mapWidth;
    private int mapHeight;

    public Map(List<List<ATile>> tileMatrix, int mapWidth, int mapHeight) {
        this.tileMatrix = tileMatrix;
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
    }

    /**
     * A getter for the area attribute of the Map object.
     * @return (Integer) area of the map
     */
    public int getArea() {
        return mapWidth * mapHeight;
    }

    /**
     *  A getter for the tileMatrix attribute of the Map object.
     *  @return (ArrayList<ArrayList<Tile>>) matrix of Tiles representing the map in the game logic.
     */
    public List<List<ATile>> getTileMatrix() {
        return tileMatrix;
    }
}