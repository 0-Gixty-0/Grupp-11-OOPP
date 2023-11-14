import static org.junit.Assert.assertEquals;

import java.awt.Point;

import org.junit.Test;

import com.group11.model.PlayableEntity;
import com.group11.model.Ship;



public class PlayableEntityTest {

    @Test
    public void testMoveUp() {
        Ship testShip = new Ship(null, new Point(0,0), 0, 0, 0, 0);
        PlayableEntity player = new PlayableEntity(testShip, "testy mcTest");
        player.getBody().setVelocity(2);
        player.moveCommand(0);
        int playerY = (int) player.getBody().getPos().getY();
        int playerX = (int) player.getBody().getPos().getX();
        assertEquals(2, playerY);
        assertEquals(0, playerX);
    }

    @Test
    public void testMoveUpRightAngle() {
        Ship testShip = new Ship(null, new Point(0,0), 0, 0, 0, 0);
        PlayableEntity player = new PlayableEntity(testShip, "testy mcTest");
        player.getBody().setVelocity(2);
        player.moveCommand(1);
        int playerY = (int) player.getBody().getPos().getY();
        int playerX = (int) player.getBody().getPos().getX();
        assertEquals(2, playerY);
        assertEquals(2, playerX);
    }

    @Test
    public void testMoveRight() {
        Ship testShip = new Ship(null, new Point(0,0), 0, 0, 0, 0);
        PlayableEntity player = new PlayableEntity(testShip, "testy mcTest");
        player.getBody().setVelocity(2);
        player.moveCommand(2);
        int playerY = (int) player.getBody().getPos().getY();
        int playerX = (int) player.getBody().getPos().getX();
        assertEquals(0, playerY);
        assertEquals(2, playerX);
    }

    @Test
    public void testMoveDownRightAngle() {
        Ship testShip = new Ship(null, new Point(0,0), 0, 0, 0, 0);
        PlayableEntity player = new PlayableEntity(testShip, "testy mcTest");
        player.getBody().setVelocity(2);
        player.moveCommand(3);
        int playerY = (int) player.getBody().getPos().getY();
        int playerX = (int) player.getBody().getPos().getX();
        assertEquals(-2, playerY);
        assertEquals(2, playerX);
    }

    @Test
    public void testMoveDown() {
        Ship testShip = new Ship(null, new Point(0,0), 0, 0, 0, 0);
        PlayableEntity player = new PlayableEntity(testShip, "testy mcTest");
        player.getBody().setVelocity(2);
        player.moveCommand(4);
        int playerY = (int) player.getBody().getPos().getY();
        int playerX = (int) player.getBody().getPos().getX();
        assertEquals(-2, playerY);
        assertEquals(0, playerX);
    }

    @Test
    public void testMoveDownLeftAngle() {
        Ship testShip = new Ship(null, new Point(0,0), 0, 0, 0, 0);
        PlayableEntity player = new PlayableEntity(testShip, "testy mcTest");
        player.getBody().setVelocity(2);
        player.moveCommand(5);
        int playerY = (int) player.getBody().getPos().getY();
        int playerX = (int) player.getBody().getPos().getX();
        assertEquals(-2, playerY);
        assertEquals(-2, playerX);
    }

    @Test
    public void testMoveLeft() {
        Ship testShip = new Ship(null, new Point(0,0), 0, 0, 0, 0);
        PlayableEntity player = new PlayableEntity(testShip, "testy mcTest");
        player.getBody().setVelocity(2);
        player.moveCommand(6);
        int playerY = (int) player.getBody().getPos().getY();
        int playerX = (int) player.getBody().getPos().getX();
        assertEquals(0, playerY);
        assertEquals(-2, playerX);
    }

    @Test
    public void testMoveUpLeftAngle() {
        Ship testShip = new Ship(null, new Point(0,0), 0, 0, 0, 0);
        PlayableEntity player = new PlayableEntity(testShip, "testy mcTest");
        player.getBody().setVelocity(2);
        player.moveCommand(7);
        int playerY = (int) player.getBody().getPos().getY();
        int playerX = (int) player.getBody().getPos().getX();
        assertEquals(2, playerY);
        assertEquals(-2, playerX);
    }

    @Test
    public void testAttackCommand() {
        //Placeholder for later implementation.
    }

    @Test
    public void testInteractCommand() {
        //Placeholder for later implementation.
    }
}

