package com.group11.Model;

/**
 * Map is a representation of a two dimensional physical map in the form of an object containing Matrixes.
 */
public class Map {
    
    //private Tile [][] tileMatrix;
    private int [][] graphicMatrix;

    /**
     * Creates a Map object out of a TileMatrix and a GraphicsMatrix.
     * @param graphicsMatrix a matrix of ints each representing a certain tile texture.
     */
    public Map(/*Tile [][] tileMatrix*/ int [][] graphicMatrix ) {
        this.graphicMatrix = graphicMatrix;
    }

    /**
     * A getter for the graphicMatris attribute of the Map object.
     * @return (int [][]) matrix of integers representing a certain tile texture.
     */
    public int [][] getGraphicMatrix() {
        return graphicMatrix;
    }

    
    /**
     *  A getter for the tileMatrix attribute of the Map object.
     *  @return (Tile [][]) matrix of Tiles representing the map in the game logic.
     */
     /*
     * public Tile [][] getTileMatrix() {
     *  return tileMatrix;
     * }
     */
    

}
