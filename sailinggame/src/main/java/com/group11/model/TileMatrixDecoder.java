package com.group11.model;

import java.util.ArrayList;

/**
 * A class for converting Matrix<Tile> in Map objects to Matrix<Int> which is a non model dependent medium.
 * The view converts the Matrix<Int> into its own domain specific language to display the graphics on the screen.
 */
public final class TileMatrixDecoder {
    
    /**
     * Dont use this class by instantiation use it by its static methods.
     */
    private TileMatrixDecoder() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Function used to decode a matrix of tiles, representing a map, into a matrix of ints that is used by the view.
     * @param matrix A Matrix<Tile> (ArrayList of ArrayLists) you want to convert.
     * @return (Matrix<Integer>) representation of map in textureId's.
     */
    public static ArrayList<ArrayList<Integer>> decodeIntoIntMatrix(ArrayList<ArrayList<ATile>> matrix) {
        
        ArrayList<ArrayList<Integer>> intMatrix = new ArrayList<ArrayList<Integer>>();

        for (int row = 0; row < matrix.size(); row++) {

            intMatrix.add(new ArrayList<Integer>());

            for (int col = 0; col < matrix.get(row).size(); col++) {

                int textureId = matrix.get(row).get(col).getTextureId();

                intMatrix.get(row).add(col, textureId);
            
            }
        }

        return intMatrix;
    }

}
