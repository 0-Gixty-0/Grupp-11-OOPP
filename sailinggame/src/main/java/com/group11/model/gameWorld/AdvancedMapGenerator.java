package com.group11.model.gameWorld;
import com.sudoplay.joise.module.ModuleBasisFunction;
import com.sudoplay.joise.module.ModuleFractal;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * This class is used as an alternative map generator. It uses a fractal noise function
 * to generate a map with a more natural-looking terrain.
 */
public class AdvancedMapGenerator implements IMapGenerator {

    /**
     * Generates a map with a given side length. The map is generated using a fractal noise function,
     * which creates a more natural-looking terrain compared to a simple random distribution.
     * 
     * @param side The side length of the map.
     * @return A Map object representing the generated map. The map consists of a matrix of ATile objects,
     *         where each ATile can be a LandTile or a SeaTile, depending on the value of the noise function
     *         at that point.
     */
    @Override
    public Map generateMap(int side) {
        // Set up the basis function for the fractal noise generator
        ModuleBasisFunction basisFunction = new ModuleBasisFunction();
        basisFunction.setType(ModuleBasisFunction.BasisType.SIMPLEX);
        basisFunction.setSeed(System.nanoTime());

        // Set up the fractal noise generator
        ModuleFractal fractal = new ModuleFractal();
        fractal.setType(ModuleFractal.FractalType.MULTI);
        fractal.setAllSourceBasisTypes(ModuleBasisFunction.BasisType.SIMPLEX);
        fractal.setNumOctaves(1);
        fractal.setFrequency(0.5);

        // Create the tile matrix that will hold the generated map
        List<List<ATile>> tileMatrix = new ArrayList<>();

        // Generate a random offset for the noise function, to ensure a different map each time
        Random rand = new Random();
        double offsetX = rand.nextDouble() * 1000 - 500; // Random offset between -500 and 500
        double offsetY = rand.nextDouble() * 1000 - 500;

        // Generate the map
        for (int x = 0; x < side; x++) {
            List<ATile> tileRow = new ArrayList<ATile>();
            for (int y = 0; y < side; y++) {
                // Get the noise value for the current coordinates
                double noiseValue = fractal.get((x / 10.0 + offsetX)*(side/50), (y / 10.0 + offsetY)*(side/50));
                // Depending on the noise value, add a SeaTile or a LandTile to the current row
                if (noiseValue < 0.6) {
                    tileRow.add(new SeaTile(new Point(x, y)));
                } else {
                    tileRow.add(new LandTile(new Point(x, y)));
                }
            }
            // Add the current row to the tile matrix
            tileMatrix.add(tileRow);
        }

        // Return a new Map object with the generated tile matrix
        return new Map(tileMatrix, side);
    }
}