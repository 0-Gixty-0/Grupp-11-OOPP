package com.group11.model;

public class UnplayableEntity extends AMovableEntity {

    /**
     * Used to create a movable entity
     *
     * @param body     The body it should use
     * @param name     The entities name
     * @param friendly A single factor which assigns the life long allegience of the entity
     */
    protected UnplayableEntity(AMovableBody body, String name, Boolean friendly) {
        super(body, name, friendly);
    }

    @Override
    public void moveCommand(Integer direction) {
        int[][] directions = {{0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}, {-1,0}, {-1,1}};
        this.moveHelper(directions[direction]);
    }

    /**
     * This method checks if the entities body has a weapon and if so fires it in the desired direction
     * @param direction The direction to fire the weapon
     */
    @Override
    public void attackCommand(Integer direction) {
        int[][] directions = {{0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}, {-1,0}, {-1,1}};
        if (this.getBody() instanceof HasWeapon) {
            ((HasWeapon) this.getBody()).fireWeapon(directions[direction]);
        }
    }

    @Override
    public void interactCommand() {
        // Currently not implemented
    }
}
