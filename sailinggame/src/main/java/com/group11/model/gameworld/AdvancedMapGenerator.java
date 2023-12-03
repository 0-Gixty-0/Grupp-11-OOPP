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

    private static final int NUM_OCTAVES = 1;
    private static final double FREQUENCY = 0.5;
    private static final double NOISE_THRESHOLD = 0.6;
    private static final int OFFSET_RANGE = 1000;
    private static final int OFFSET_SHIFT = 500;
    private static final double SCALE_FACTOR = 10.0;
    private static final double SIDE_SCALE = 50.0;

    @Override
    public Map generateMap(int side) {
        ModuleFractal fractal = setupFractalNoiseGenerator();

        List<List<ATile>> tileMatrix = new ArrayList<>();

        double[] offsets = generateRandomOffsets();

        generateMapTiles(side, fractal, tileMatrix, offsets);

        return new Map(tileMatrix, side);
    }

    private ModuleFractal setupFractalNoiseGenerator() {
        ModuleBasisFunction basisFunction = new ModuleBasisFunction();
        basisFunction.setType(ModuleBasisFunction.BasisType.SIMPLEX);
        basisFunction.setSeed(System.nanoTime());

        ModuleFractal fractal = new ModuleFractal();
        fractal.setType(ModuleFractal.FractalType.MULTI);
        fractal.setAllSourceBasisTypes(ModuleBasisFunction.BasisType.SIMPLEX);
        fractal.setNumOctaves(NUM_OCTAVES);
        fractal.setFrequency(FREQUENCY);

        return fractal;
    }

    private double[] generateRandomOffsets() {
        Random rand = new Random();
        double offsetX = rand.nextDouble() * OFFSET_RANGE - OFFSET_SHIFT;
        double offsetY = rand.nextDouble() * OFFSET_RANGE - OFFSET_SHIFT;

        return new double[] { offsetX, offsetY };
    }

    private void generateMapTiles(int side, ModuleFractal fractal, List<List<ATile>> tileMatrix, double[] offsets) {
        for (int x = 0; x < side; x++) {
            List<ATile> tileRow = new ArrayList<>();
            for (int y = 0; y < side; y++) {
                double noiseValue = fractal.get((x / SCALE_FACTOR + offsets[0])*(side/SIDE_SCALE), (y / SCALE_FACTOR + offsets[1])*(side/SIDE_SCALE));
                tileRow.add(createTileBasedOnNoiseValue(noiseValue, x, y));
            }
            tileMatrix.add(tileRow);
        }
    }

    private ATile createTileBasedOnNoiseValue(double noiseValue, int x, int y) {
        if (noiseValue < NOISE_THRESHOLD) {
            return new SeaTile(new Point(x, y));
        } else {
            return new LandTile(new Point(x, y));
        }
    }
}