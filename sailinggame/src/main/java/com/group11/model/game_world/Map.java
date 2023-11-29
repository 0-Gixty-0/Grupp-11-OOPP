package com.group11.model.game_world;

import java.util.List;

/**
 * Map is a representation of a two-dimensional physical map in the form of an object containing Matrix's.
 */
public class Map {
    
    private int area;
    private List<List<ATile>> tileMatrix;

    /**
     * Creates a Map object out of a TileMatrix and a GraphicsMatrix, Constructor is package projected because
     * Maps should be created by map generator.
     *
     * @param side the size of a side in a map, a map is always a square.
     */
    protected Map(List<List<ATile>> tileMatrix, int side) {
        this.tileMatrix = tileMatrix;
        this.area = side*side;
    }

    /**
     * A getter for the area attribute of the Map object.
     * @return (Integer) area of the map
     */
    public int getArea() {
        return area;
    }

    /**
     *  A getter for the tileMatrix attribute of the Map object.
     *  @return (ArrayList<ArrayList<Tile>>) matrix of Tiles representing the map in the game logic.
     */
    public List<List<ATile>> getTileMatrix() {
        return tileMatrix;
    }
}