package com.group11.model.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.group11.model.gameworld.ATile;
import com.group11.model.gameworld.LandTile;
import com.group11.model.gameworld.SeaTile;

/**
 * A class for converting Matrix<Tile> in Map objects to Matrix<Int> which is a non model dependent medium.
 * The view converts the Matrix<Int> into its own domain specific language to display the graphics on the screen.
 */
public final class UViewTileMatrixDecoder {
    

    private static List<List<ATile>> tileMatrix;

    /**
     * Mapping of Tile classes to textureId's.
     */
    private static HashMap<Class<? extends ATile>, Integer> tileMap = new HashMap<>();
    static {
        tileMap.put(LandTile.class, 0);
        tileMap.put(SeaTile.class, 1);
    }

    /**
     * Dont use this class by instantiation use it by its static methods.
     */
    private UViewTileMatrixDecoder() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Function used to get the textureId of a tile.
     * @param tile The tile you want to get the textureId of.
     * @return (int) textureId of the tile.
     */ 
    private static int getTextureId(ATile tile) {
        Class<? extends ATile> tileClass = tile.getClass();
        Integer textureId = tileMap.get(tileClass);
        if (textureId == -1) throw new IllegalArgumentException("Tile class not found in tileMap");
        return textureId;
    }

    public static void setTilematrix(List<List<ATile>> tileMatrix) {
        UViewTileMatrixDecoder.tileMatrix = tileMatrix;
    }

    /**
     * Function used to decode a matrix of tiles, representing a map, into a matrix of ints that is used by the view.
     * @param matrix A Matrix<Tile> (ArrayList of ArrayLists) you want to convert.
     * @return (Matrix<Integer>) representation of map in textureId's.
     */
    public static List<List<Integer>> decodeIntoIntMatrix() {
        
        List<List<Integer>> intMatrix = new ArrayList<>();

        for (int row = 0; row < tileMatrix.size(); row++) {

            intMatrix.add(new ArrayList<>());

            for (int col = 0; col < tileMatrix.get(row).size(); col++) {

                ATile tile = tileMatrix.get(row).get(col);

                Integer textureId = UViewTileMatrixDecoder.getTextureId(tile);

                intMatrix.get(row).add(col, textureId);
            
            }
        }

        return intMatrix;
    }

}

