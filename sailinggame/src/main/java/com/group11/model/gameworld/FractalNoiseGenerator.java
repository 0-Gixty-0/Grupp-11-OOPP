package com.group11.model.gameworld;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.sudoplay.joise.module.ModuleBasisFunction;
import com.sudoplay.joise.module.ModuleFractal;

public class FractalNoiseGenerator {
    // Constants for the fractal noise generation
    private static final int NUM_OCTAVES = 1;
    private static final double FREQUENCY = 0.5;
    // Increase the threshold to generate fewer islands
    private static final double NOISE_THRESHOLD = 0.5;
    private static final int OFFSET_RANGE = 1000;
    private static final int OFFSET_SHIFT = 500;
    private static final double SCALE_FACTOR = 10.0;
    private static final double SIDE_SCALE = 50.0;

    

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



}
