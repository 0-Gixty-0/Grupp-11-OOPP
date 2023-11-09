package com.group11.Model;
import java.util.ArrayList;

/**
 * A very basic and crude MapGenerator implementation.
 */
public class BasicMapGenerator extends AMapGenerator {

    @Override
    /*
     Dont use this method if you are making a new World, 
     use this if you want to generate a new map for an old world.
     Leaving this method public and not protected for that reason.
     */
    public Map generateMap(int side) {

        Integer quarterSide = side/4;
        ArrayList<ArrayList<ATile>> tileMatrix = new ArrayList<>();
        ArrayList<ArrayList<Integer>> graphicsMatrix = new ArrayList<>();

        for (int i = 0; i < side; i++) {

            ArrayList<ATile> tileRow = new ArrayList<ATile>(); //Create rows
            ArrayList<Integer> graphicRow = new ArrayList<Integer>();

            for (int k = 0; k < side; k++) { 

                //Creates a square of land in the middle of the matrix withe a quarterSide distance to the edge
                if ((k >= quarterSide) && (k <= side-quarterSide) && (i >= quarterSide) && (i <= side-quarterSide)) { //Add landtiles
                    tileRow.add(new LandTile()); //Should add landtile
                    graphicRow.add(1); //Add landtile id to graphicmap
                }

                else {
                    tileRow.add(new SeaTile()); //Should add seatile
                    graphicRow.add(0); //Add seatile id to graphicmap
                }

            }

            tileMatrix.add(tileRow);
            graphicsMatrix.add(graphicRow);

        }

        return new Map(tileMatrix, graphicsMatrix, side);
    }
    
}
