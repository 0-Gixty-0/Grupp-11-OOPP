package com.group11.Model;
import java.util.ArrayList;

/**
 * A very basic and crude MapGenerator implementation.
 */
public class BasicMapGenerator extends AMapGenerator {

    @Override
    public Map generateMap(Integer side) {

        Integer quarterSide = side/4;
        ArrayList<ArrayList<ATile>> tileMatrix = new ArrayList<>();
        ArrayList<ArrayList<Integer>> graphicsMatrix = new ArrayList<>();

        for (Integer i = 0; i < side; i++) {

            ArrayList<ATile> tileRow = new ArrayList<ATile>(); //Create a row
            ArrayList<Integer> graphicRow = new ArrayList<Integer>();

            for (Integer k = 0; k < side; k++) { 

                //Creates a square of land in the middle of the matrix withe a quarterSide distance to the edge
                if ((k >= quarterSide) && (k <= side-quarterSide) && (i >= quarterSide) && (i <= side-quarterSide)) { //Add landtiles
                    tileRow.add(new ATile()); //Add landtile
                    graphicRow.add(1); //Add landtile id to graphicmap
                }

                else {
                    tileRow.add(new ATile()); //Add seatile
                    graphicRow.add(0); //Add seatile id to graphicmap
                }

            }

            tileMatrix.add(tileRow);
            graphicsMatrix.add(graphicRow);

        }

        return new Map(tileMatrix, graphicsMatrix, side);
    }
    
}
