package com.group11.model;

import java.awt.*;

public class EntityDirector {
    private EntityBuilder builder;

    public EntityDirector(EntityBuilder builder) {
        this.builder = builder;
    }

    public void changeBuilder(EntityBuilder builder) {
        this.builder = builder;
    }

    public AEntity createPlayer(Point position) {
        builder.reset();
        builder.setName("Player");
        builder.setFriendlyStatus(true);
        builder.setPosition(position);
        builder.setAttributesForLevel(1);
        builder.setBody();
        return builder.createEntity();
    }

    public AEntity createEnemy(Point position, int lvl) {
        builder.reset();
        builder.setName(String.format("Enemy: lvl %d",lvl));
        builder.setFriendlyStatus(true);
        builder.setPosition(position);
        builder.setAttributesForLevel(lvl);
        builder.setBody();
        return builder.createEntity();
    }
}

