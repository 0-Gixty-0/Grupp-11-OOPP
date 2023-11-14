package com.group11.model;

public abstract class ATextureIdentifiable {
    private int texture;

    protected ATextureIdentifiable(int textureId) {
        this.texture = textureId;
    }

    public int getTextureId(){
        return this.texture;
    }
}
