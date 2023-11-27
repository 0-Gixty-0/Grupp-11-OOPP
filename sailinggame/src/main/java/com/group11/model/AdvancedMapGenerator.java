package com.group11.model;
import com.sudoplay.joise.module.ModuleBasisFunction;
import com.sudoplay.joise.module.ModuleFractal;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class AdvancedMapGenerator implements IMapGenerator {

    @Override
    public Map generateMap(int side) {
        ModuleBasisFunction basisFunction = new ModuleBasisFunction();
        basisFunction.setType(ModuleBasisFunction.BasisType.SIMPLEX);
        basisFunction.setSeed(System.nanoTime());

        ModuleFractal fractal = new ModuleFractal();
        fractal.setType(ModuleFractal.FractalType.MULTI);
        fractal.setAllSourceBasisTypes(ModuleBasisFunction.BasisType.SIMPLEX);
        fractal.setNumOctaves(1);
        fractal.setFrequency(0.5);

        List<List<ATile>> tileMatrix = new ArrayList<>();

        for (int x = 0; x < side; x++) {
            List<ATile> tileRow = new ArrayList<ATile>();
            for (int y = 0; y < side; y++) {
                double noiseValue = fractal.get((x / 10.0)*(side/50), (y / 10.0)*(side/50));
                if (noiseValue < 0.6) {
                    tileRow.add(new SeaTile(new Point(x, y)));
                } else {
                    tileRow.add(new LandTile(new Point(x, y)));
                }
            }
            tileMatrix.add(tileRow);
        }

        // for (List<ATile> row : tileMatrix) {
        //     for (ATile tile : row) {
        //         System.out.print(tile.toString() + " ");
        //     }
        //     System.out.println();
        // }

        return new Map(tileMatrix, side);
    }
}