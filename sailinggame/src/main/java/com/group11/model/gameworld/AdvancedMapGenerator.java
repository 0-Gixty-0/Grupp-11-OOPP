package com.group11.model.gameworld;
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

    // Constants for the fractal noise generation
    private static final int NUM_OCTAVES = 1;
    private static final double FREQUENCY = 0.5;
    private static final double NOISE_THRESHOLD = 0.6;
    private static final int OFFSET_RANGE = 1000;
    private static final int OFFSET_SHIFT = 500;
    private static final double SCALE_FACTOR = 10.0;
    private static final double SIDE_SCALE = 50.0;

    /**
     * Generates a map of a given size using fractal noise.
     * @param mapWidth The width of the map to generate.
     * @param mapHeight The height of the map to generate.
     * @return The generated map.
     */
    @Override
    public Map generateMap(int mapWidth, int mapHeight) {
        // Set up the fractal noise generator
        ModuleFractal fractal = setupFractalNoiseGenerator();

        // Create the tile matrix that will hold the generated map
        List<List<ATile>> tileMatrix = new ArrayList<>();

        // Generate a random offset for the noise function, to ensure a different map each time
        double[] offsets = generateRandomOffsets();

        // Generate the map tiles
        generateMapTiles(mapWidth, mapHeight, fractal, tileMatrix, offsets);

        // Return a new Map object with the generated tile matrix
        return new Map(tileMatrix, mapWidth, mapHeight);
    }

    /**
     * Sets up the fractal noise generator.
     * @return The configured fractal noise generator.
     */
    private ModuleFractal setupFractalNoiseGenerator() {
        // Set up the basis function for the fractal noise generator
        ModuleBasisFunction basisFunction = new ModuleBasisFunction();
        basisFunction.setType(ModuleBasisFunction.BasisType.SIMPLEX);
        basisFunction.setSeed(System.nanoTime());

        // Set up the fractal noise generator
        ModuleFractal fractal = new ModuleFractal();
        fractal.setType(ModuleFractal.FractalType.MULTI);
        fractal.setAllSourceBasisTypes(ModuleBasisFunction.BasisType.SIMPLEX);
        fractal.setNumOctaves(NUM_OCTAVES);
        fractal.setFrequency(FREQUENCY);

        return fractal;
    }

    /**
     * Generates a random offset for the noise function. This ensures that each generated map is unique.
     * @return An array containing the x and y offsets.
     */
    private double[] generateRandomOffsets() {
        Random rand = new Random();
        double offsetX = rand.nextDouble() * OFFSET_RANGE - OFFSET_SHIFT;
        double offsetY = rand.nextDouble() * OFFSET_RANGE - OFFSET_SHIFT;

        return new double[] { offsetX, offsetY };
    }

    /**
     * Generates the map tiles based on the noise values. Each tile is either a SeaTile or a LandTile,
     * depending on whether the noise value at that point is above or below a certain threshold.
     * @param mapWidth The width of the map to generate.
     * @param mapHeight The height of the map to generate.
     * @param fractal The fractal noise generator.
     * @param tileMatrix The tile matrix to fill with generated tiles.
     * @param offsets The offsets for the noise function.
     */
    private void generateMapTiles(int mapWidth, int mapHeight, ModuleFractal fractal, List<List<ATile>> tileMatrix, double[] offsets) {
        for (int y = 0; y < mapHeight; y++) {
            List<ATile> row = new ArrayList<>();
            for (int x = 0; x < mapWidth; x++) {
                // Calculate the noise value at this point
                double noiseValue = fractal.get((x / SCALE_FACTOR + offsets[0])*(mapWidth/SIDE_SCALE), (y / SCALE_FACTOR + offsets[1])*(mapHeight/SIDE_SCALE));

                // Add the tile to the row
                row.add(createTileBasedOnNoiseValue(noiseValue, x, y));
            }
            // Add the row to the tile matrix
            tileMatrix.add(row);
        }
    }

    /**
     * Creates a tile based on a noise value. If the noise value is below a certain threshold, a SeaTile is created.
     * Otherwise, a LandTile is created.
     * @param noiseValue The noise value.
     * @param x The x coordinate of the tile.
     * @param y The y coordinate of the tile.
     * @return The created tile.
     */
    private ATile createTileBasedOnNoiseValue(double noiseValue, int x, int y) {
        if (noiseValue < NOISE_THRESHOLD) {
            return new SeaTile(new Point(x, y));
        } else {
            return new LandTile(new Point(x, y));
        }
    }
}