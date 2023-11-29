package com.group11.model.game_world;

/**
 * World is a composition of Maps.
 */
public class World {

    private Map map;

    /**
     * Creates a World out of a Map. Constructor is protected because Worlds should only be created by WorldGenerators.
     * @param map the map used in the world
     */
    protected World(Map map) {
        this.map = map;
    }

    /**
     * getter for the map attribute
     * @return (Map)
     */
    public Map getMap() {
        return map;
    }

    /**
     * setter fot the map attribute
     * @param map
     */
    public void setMap(Map map) {
        this.map = map;
    }

}
