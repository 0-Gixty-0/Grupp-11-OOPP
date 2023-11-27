package com.group11.model;

public class EntityDirector {
    private EntityBuilder builder;

    public EntityDirector(EntityBuilder builder) {
        this.builder = builder;
    }

    public void changeBuilder(EntityBuilder builder) {
        this.builder = builder;
    }

    public AEntity createPlayer() {
        builder.reset();

    }

    public AEntity createEnemy(int lvl) {

    }
}

