package com.group11.model.gameentites;

/**
 * A movable entity is a subset of entities that can move around the gameworld
 */
public class CommandableEntity extends AEntity implements ICommandable {

    /**
     * Used to create a commandable entity
     * @param body The body it should use
     * @param name The entity's name
     * @param friendly A single factor which assigns the lifelong allegiance of the entity
     */
    public CommandableEntity(AMovableBody body, String name, Boolean friendly) {
        super(body, name, friendly);
    }

    /**
     * Sets the body of the movable entity.
     * @param body The new body of the movable entity.
     */
    public void setMovableBody(AMovableBody body) {
        this.setBody(body);
    }

    /**
     * Issue a move command to an entity in 8 difference directions using these integers as arguments:
     * 0 moves straight up,
     * 1 moves at a right angle up,
     * 2 moves straight right,
     * 3 moves at a right angle down,
     * 4 moves at straight down,
     * 5 moves at a left angle down,
     * 6 moves straight left,
     * 7 move at a left angle up,
     * @param direction Moves the Entity in the chosen direction (see the index above).
     */
    @Override
    public void moveIfPossible(Integer direction) {
        int[][] directions = {{-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}};
        if (this.getBody() instanceof IMovable) {
            ((IMovable) this.getBody()).moveIfPossible(directions[direction]);
        } else {
            System.out.println(String.format("Objects of type %s cannot move",this.getBody().getClass().getName()));
        }
    }

    /**
     * This method checks if the entities body has a weapon and if so fires it in the desired direction
     * @param direction The direction to fire the weapon
     */
    @Override
    public void attackIfPossible(Integer direction) {
        int[][] directions = {{-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}};
        if (this.getBody() instanceof IHasWeapon) {
            ((IHasWeapon) this.getBody()).fireWeapon(directions[direction]);
        } else {
            System.out.println(String.format("Objects of type %s cannot attack",this.getBody().getClass().getName()));
        }
    }

    @Override
    public void interactIfPossible() {
        if (this.getBody() instanceof ICanInteract) {
            //Placeholder for later implementation.
        } else {
            System.out.println(String.format("Objects of type %s cannot interact",this.getBody().getClass().getName()));
        }
    }

}