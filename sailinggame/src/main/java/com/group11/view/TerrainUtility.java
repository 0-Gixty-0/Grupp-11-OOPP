package com.group11.view;

import java.awt.Dimension;
import java.awt.Point;

public final class TerrainUtility extends AViewUtility {

    private static TerrainUtility instance;

    private TerrainUtility() {
        super();
    }

    public static TerrainUtility getInstance() {
        if (instance == null) {
            instance = new TerrainUtility();
        }
        return instance;
    }

    @Override
    protected AViewTile tileType(int id, Dimension dimension, Point matrixPosition, Point pixelPosition) {
        return new TerrainTile(id, dimension, matrixPosition, pixelPosition);
    }
    
}
