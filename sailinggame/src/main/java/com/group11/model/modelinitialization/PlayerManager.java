package com.group11.model.modelinitialization;

import com.group11.model.gameentites.CommandableEntity;

/**
 * Class for managing the player
 */
public class PlayerManager {

    private CommandableEntity player;

    public PlayerManager(CommandableEntity player) {
        this.player = player;
        ScoreBoard.addEntityToScoreBoard(player);
    }

    /**
     * Gets the score of the player
     * @return the score of the player
     */
    protected int getPlayerScore() {
        return ScoreBoard.getScore(player);
    }

    /**
     * Updates player position based on keyboard input
     */
    protected void updatePlayer(int movementInput, int fireInput) {

        if (movementInput >= 0) {
            this.player.moveIfPossible(movementInput);
        }
        if (fireInput >= 0) {
            this.player.attackIfPossible(fireInput);
        }
    }
}
