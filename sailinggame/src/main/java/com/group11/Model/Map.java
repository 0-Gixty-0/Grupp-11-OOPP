package com.group11.model;

import java.util.ArrayList;

/**
 * Map is a representation of a two dimensional physical map in the form of an object containing Matrixes.
 */
public class Map {
    
    private int area;
    private ArrayList<ArrayList<ATile>> tileMatrix;
    private ArrayList<ArrayList<Integer>> graphicMatrix;

    /**
     * Creates a Map object out of a TileMatrix and a GraphicsMatrix, Constructor is package procted because
     * Maps should be created by map generator.
     * @param graphicsMatrix a matrix of ints each representing a certain tile texture.
     * @param side the size of a side in a map, a map is always a square.
     */
    protected Map(ArrayList<ArrayList<ATile>> tileMatrix, ArrayList<ArrayList<Integer>> graphicMatrix, int side) {
        this.tileMatrix = tileMatrix;
        this.graphicMatrix = graphicMatrix;
        this.area = side*side;
    }

    /**
     * A getter for the graphicMatris attribute of the Map object.
     * @return (ArrayList<ArrayList<Integer>>) matrix of integers representing a certain tile texture.
     */
    public ArrayList<ArrayList<Integer>> getGraphicMatrix() {
        return graphicMatrix;
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
