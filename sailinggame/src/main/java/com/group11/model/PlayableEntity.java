package com.group11.model;

/**
 * The PlayableEntity class represents an instance of the player in the game world. 
 */
public class PlayableEntity extends CommandableEntity {

 /**
  * Constructor for a playable entity (commonly just the player)
  * @param body The body the player should use.
  * @param name The name of the player..
  */
  public PlayableEntity(AMovableBody body, String name) {
      super(body, name, true);
  }

  /**
   * Issue a move command to a entity in 8 difference directions using these integers as arguments:
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
      //Placeholder for later implementation.
  }
  
}
