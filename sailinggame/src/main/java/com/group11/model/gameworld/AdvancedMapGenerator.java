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
    // Increase the threshold to generate fewer islands
    private static final double NOISE_THRESHOLD = 0.5;
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

        Map map = new Map(tileMatrix, mapWidth, mapHeight);

        while(isAllSeaConnected(map) == false) {
            offsets = generateRandomOffsets();
            tileMatrix = new ArrayList<>();
            generateMapTiles(mapWidth, mapHeight, fractal, tileMatrix, offsets);
            map = new Map(tileMatrix, mapWidth, mapHeight);
        }

        // Return a new Map object with the generated tile matrix
        return map;
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

    private boolean isAllSeaConnected(Map map) {
        boolean[][] visited = new boolean[map.getMapWidth()][map.getMapHeight()];
        Point start = findFirstSeaTile(map);
        if (start == null) {
            return false; // No sea tiles found
        }
        floodFill(map, visited, start.x, start.y);
        return areAllSeaTilesVisited(map, visited);
    }
    
    private Point findFirstSeaTile(Map map) {
        for (int x = 0; x < map.getMapWidth(); x++) {
            for (int y = 0; y < map.getMapHeight(); y++) {
                if (map.getTile(x, y) instanceof SeaTile) {
                    return new Point(x, y);
                }
            }
        }
        return null; // No sea tiles found
    }
    
    private void floodFill(Map map, boolean[][] visited, int x, int y) {
        if (x < 0 || x >= map.getMapWidth() || y < 0 || y >= map.getMapHeight()) {
            return; // Out of bounds
        }
        if (visited[x][y] || map.getTile(x,y) instanceof LandTile) {
            return; // Already visited or not a sea tile
        }
        visited[x][y] = true;
        floodFill(map,visited, x + 1, y); // Right
        floodFill(map,visited, x - 1, y); // Left
        floodFill(map,visited, x, y + 1); // Down
        floodFill(map,visited, x, y - 1); // Up
    }

    private boolean areAllSeaTilesVisited(Map map, boolean[][] visited) {
        for (int x = 0; x <  map.getMapWidth(); x++) {
            for (int y = 0; y < map.getMapHeight(); y++) {
                if (map.getTile(x,y) instanceof SeaTile && !visited[x][y]) {
                    return false; // Found a sea tile that was not visited
                }
            }
        }
        return true; // All sea tiles were visited
    }
}