package com.group11.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A class for converting Matrix<Tile> in Map objects to Matrix<Int> which is a non model dependent medium.
 * The view converts the Matrix<Int> into its own domain specific language to display the graphics on the screen.
 */
public final class TileMatrixDecoder {
    
    /**
     * Mapping of Tile classes to textureId's.
     */
    private static ArrayList<Class<? extends ATile>> tileMap = new ArrayList<>();
    static {
        tileMap.add(LandTile.class); // 0
        tileMap.add(SeaTile.class); // 1
    }

    /**
     * Dont use this class by instantiation use it by its static methods.
     */
    private TileMatrixDecoder() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Function used to get the textureId of a tile.
     * @param tile The tile you want to get the textureId of.
     * @return (int) textureId of the tile.
     */ 
    private static int getTextureId(ATile tile) {
        Class<? extends ATile> tileClass = tile.getClass();
        Integer textureId = tileMap.indexOf(tileClass);
        if (textureId == -1) throw new IllegalArgumentException("Tile class not found in tileMap");
        return textureId;
    }

    /**
     * Function used to decode a matrix of tiles, representing a map, into a matrix of ints that is used by the view.
     * @param matrix A Matrix<Tile> (ArrayList of ArrayLists) you want to convert.
     * @return (Matrix<Integer>) representation of map in textureId's.
     */
    public static List<List<Integer>> decodeIntoIntMatrix(List<List<ATile>> matrix) {
        
        List<List<Integer>> intMatrix = new ArrayList<List<Integer>>();

        for (int row = 0; row < matrix.size(); row++) {

            intMatrix.add(new ArrayList<Integer>());

            for (int col = 0; col < matrix.get(row).size(); col++) {

                ATile tile = matrix.get(row).get(col);

                Integer textureId = TileMatrixDecoder.getTextureId(tile);

                intMatrix.get(row).add(col, textureId);
            
            }
        }

        return intMatrix;
    }

}

