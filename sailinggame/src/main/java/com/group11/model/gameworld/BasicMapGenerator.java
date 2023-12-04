package com.group11.model.gameworld;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * A very basic and crude MapGenerator implementation.
 */
public class BasicMapGenerator implements IMapGenerator {

    @Override
    /*
     Don't use this method if you are making a new World,
     use this if you want to generate a new map for an old world.
     Leaving this method public and not protected for that reason.
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