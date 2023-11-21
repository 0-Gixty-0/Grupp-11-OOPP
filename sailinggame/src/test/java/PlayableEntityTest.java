import static org.junit.Assert.assertEquals;

import java.awt.Point;

import org.junit.Test;

import com.group11.model.BasicMapGenerator;
import com.group11.model.Map;
import com.group11.model.MovementUtility;
import com.group11.model.PlayableEntity;
import com.group11.model.Ship;



public class PlayableEntityTest {

    @Test
    public void testTryingToMoveOverImpassableTerrain() {
        Map map = (new BasicMapGenerator()).generateMap(50);
        MovementUtility.setMap(map);
        
        Ship testShip = new Ship(null, new Point(0,0), 0, 0, 0, 2);
        PlayableEntity player = new PlayableEntity(testShip, "testy mcTest");
        
        //Starting position is (0,0) which is the bottom left corner of the map
        for (int i = 0; i < 50; i++) { //Try to move player to the top of the map. Through the big middle island created by BasicMapNGenerator.
            player.moveCommand(1); //1 is a right up diagonal move
        }
        
        int playerY = (int) player.getPos().getY();
        int playerX = (int) player.getPos().getX();
        assertEquals(11, playerY);
        assertEquals(11, playerX);
    }

    @Test
    public void testMoveUp() {
        Map map = (new BasicMapGenerator()).generateMap(50);
        MovementUtility.setMap(map);
        Ship testShip = new Ship(null, new Point(0,0), 0, 0, 0, 2);
        PlayableEntity player = new PlayableEntity(testShip, "testy mcTest");
        player.moveCommand(0);
        int playerY = (int) player.getPos().getY();
        int playerX = (int) player.getPos().getX();
        assertEquals(1, playerY);
        assertEquals(0, playerX);
    }

    @Test
    public void testMoveUpRightAngle() {
        Map map = (new BasicMapGenerator()).generateMap(50);
        MovementUtility.setMap(map);
        Ship testShip = new Ship(null, new Point(0,0), 0, 0, 0, 2);
        PlayableEntity player = new PlayableEntity(testShip, "testy mcTest");
        player.moveCommand(1);
        int playerY = (int) player.getPos().getY();
        int playerX = (int) player.getPos().getX();
        assertEquals(1, playerY);
        assertEquals(1, playerX);
    }

    @Test
    public void testMoveRight() {
        Map map = (new BasicMapGenerator()).generateMap(50);
        MovementUtility.setMap(map);
        Ship testShip = new Ship(null, new Point(0,0), 0, 0, 0, 2);
        PlayableEntity player = new PlayableEntity(testShip, "testy mcTest");
        player.moveCommand(2);
        int playerY = (int) player.getPos().getY();
        int playerX = (int) player.getPos().getX();
        assertEquals(0, playerY);
        assertEquals(1, playerX);
    }

    @Test
    public void testMoveDownRightAngle() {
        Map map = (new BasicMapGenerator()).generateMap(50);
        MovementUtility.setMap(map);
        Ship testShip = new Ship(null, new Point(2,2), 0, 0, 0, 2);
        PlayableEntity player = new PlayableEntity(testShip, "testy mcTest");
        player.moveCommand(3);
        int playerY = (int) player.getPos().getY();
        int playerX = (int) player.getPos().getX();
        assertEquals(1, playerY);
        assertEquals(3, playerX);
    }

    @Test
    public void testMoveDown() {
        Map map = (new BasicMapGenerator()).generateMap(50);
        MovementUtility.setMap(map);
        Ship testShip = new Ship(null, new Point(2,2), 0, 0, 0, 2);
        PlayableEntity player = new PlayableEntity(testShip, "testy mcTest");
        player.moveCommand(4);
        int playerY = (int) player.getPos().getY();
        int playerX = (int) player.getPos().getX();
        assertEquals(1, playerY);
        assertEquals(2, playerX);
    }

    @Test
    public void testMoveDownLeftAngle() {
        Map map = (new BasicMapGenerator()).generateMap(50);
        MovementUtility.setMap(map);
        Ship testShip = new Ship(null, new Point(2,2), 0, 0, 0, 2);
        PlayableEntity player = new PlayableEntity(testShip, "testy mcTest");
        player.moveCommand(5);
        int playerY = (int) player.getPos().getY();
        int playerX = (int) player.getPos().getX();
        assertEquals(1, playerY);
        assertEquals(1, playerX);
    }

    @Test
    public void testMoveLeft() {
        Map map = (new BasicMapGenerator()).generateMap(50);
        MovementUtility.setMap(map);
        Ship testShip = new Ship(null, new Point(2,2), 0, 0, 0, 2);
        PlayableEntity player = new PlayableEntity(testShip, "testy mcTest");
        player.moveCommand(6);
        int playerY = (int) player.getPos().getY();
        int playerX = (int) player.getPos().getX();
        assertEquals(2, playerY);
        assertEquals(1, playerX);
    }

    @Test
    public void testMoveUpLeftAngle() {
        Map map = (new BasicMapGenerator()).generateMap(50);
        MovementUtility.setMap(map);
        Ship testShip = new Ship(null, new Point(2,2), 0, 0, 0, 2);
        PlayableEntity player = new PlayableEntity(testShip, "testy mcTest");
        player.moveCommand(7);
        int playerY = (int) player.getPos().getY();
        int playerX = (int) player.getPos().getX();
        assertEquals(3, playerY);
        assertEquals(1, playerX);
    }

    @Test
    public void testAttackCommandHasWeapon() {
        // Currently impossible to test since the side effects of the method are not implemented
    }

    @Test
    public void testAttackCommandDoesNotHaveWeapon() {
        // Currently impossible to test since the side effects of the method are not implemented
    }

    @Test
    public void testInteractCommand() {
        //Placeholder for later implementation.
    }
}

