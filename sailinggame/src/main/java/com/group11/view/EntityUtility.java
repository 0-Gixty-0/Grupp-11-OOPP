package com.group11.view;

import java.awt.Dimension;
import java.awt.Point;

public final class EntityUtility extends AViewUtility {

    private static EntityUtility instance;

    private EntityUtility() {
        super();
    }

    public static EntityUtility getInstance() {
        if (instance == null) {
            instance = new EntityUtility();
        }
        return instance;
    }

    @Override
    protected AViewTile tileType(int id, Dimension dimension, Point matrixPosition, Point pixelPosition) {
        return new EntityTile(id, dimension, matrixPosition, pixelPosition);
    }

}