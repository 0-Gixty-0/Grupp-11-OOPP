package com.group11.model.gameworld;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * A very basic and crude MapGenerator implementation.
 */
public class BasicMapGenerator implements IMapGenerator {

    @Override
    /**
     Primarly used for testing purposes as this type of map is no longer used in the game.
     @param mapWidth the width of the map to be generated
     @param mapHeight the height of the map to be generated
     @return a Map object with the specified dimensions
    */
    public Map generateMap(int mapWidth, int mapHeight) {

        Integer quarterWidth = mapWidth/4;
        Integer quarterHeight = mapHeight/4;

        List<List<ATile>> tileMatrix = new ArrayList<List<ATile>>();

        for (int i = 0; i < mapHeight; i++) {
            
            List<ATile> tileRow = new ArrayList<ATile>(); //Create rows

            for (int k = 0; k < mapWidth; k++) { 
                
                //Creates a square of land in the middle of the matrix with a quarterSide distance to the edge
                if ((k >= quarterWidth) && (k <= mapWidth-quarterWidth) && (i >= quarterHeight) && (i <= mapHeight-quarterHeight)) { //Add landtiles
                    tileRow.add(new LandTile(new Point(i,k))); //Should add landtile
                }

                else {
                    tileRow.add(new SeaTile(new Point(i, k))); //Should add seatile
                }
            }
            tileMatrix.add(tileRow);
        }
        return new Map(tileMatrix, mapWidth, mapHeight);
    }
}