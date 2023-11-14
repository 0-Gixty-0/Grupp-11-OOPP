package com.group11.model;

import java.util.ArrayList;

/**
 * Map is a representation of a two dimensional physical map in the form of an object containing Matrixes.
 */
public class Map {
    
    private int area;
    private ArrayList<ArrayList<ATile>> tileMatrix;

    /**
     * Creates a Map object out of a TileMatrix and a GraphicsMatrix, Constructor is package procted because
     * Maps should be created by map generator.
     * @param graphicMatrix a matrix of ints each representing a certain tile texture.
     * @param side the size of a side in a map, a map is always a square.
     */
    protected Map(ArrayList<ArrayList<ATile>> tileMatrix, int side) {
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
    public ArrayList<ArrayList<ATile>> getTileMatrix() {
        return tileMatrix;
    }

}
