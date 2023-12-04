package com.group11;
import com.group11.model.gameworld.World;

import java.awt.*;

public class EntitySpawner {


    private final int height;
    private final int width;
    private final World world;

    public EntitySpawner(int height, int width, World world) {
        this.height = height;
        this.width = width;
        this.world = world;
    }

    public Point spawnEntity() {
        Point pos = generateRandomPos();
        while (!checkIfPossible(pos)) {
            pos = generateRandomPos();
        }
        return pos;
    }

    public boolean checkIfPossible(Point pos) {
        if (world.getMap().getTileMatrix().get(pos.x).get(pos.y).isPassable()) {
            return true;
        }
        return false;
    }

    public Point generateRandomPos() {
        int x = (int) (Math.random() * this.height);
        int y = (int) (Math.random() * this.width);
        return new Point(x, y);
    }
}