package modeltest;

import com.group11.model.utility.UMovementUtility;
import com.group11.model.gameentites.AProjectile;
import com.group11.model.gameentites.BasicCannonBall;
import com.group11.model.gameworld.BasicMapGenerator;
import com.group11.model.gameworld.Map;

import org.junit.Test;
import static org.junit.Assert.*;

public class AProjectileTest {
    int [] direction = {1,1};
    AProjectile testCannonBall = new BasicCannonBall(direction);
    Map map = (new BasicMapGenerator()).generateMap(50,50);
    


    @Test
    public void testIsOutOfRange() {

        assertFalse(testCannonBall.isOutOfRange());
    }

    @Test
    public void testTravel() {
        UMovementUtility.setTileMatrix(map.getTileMatrix());
        testCannonBall.travel();
        assertEquals(1, testCannonBall.getDistanceTraveled());
    }

    @Test
    public void testGetDistanceTraveled() {
        assertEquals(0, testCannonBall.getDistanceTraveled());
    }

    @Test
    public void testGetDirection() {
        int[] direction = {1, 1};
        testCannonBall.setDirection(direction);
        assertEquals(testCannonBall.getDirection(), direction);
    }

    @Test
    public void testSetDirection() {
        int[] direction = {1, 1};
        testCannonBall.setDirection(direction);
        assertEquals(testCannonBall.getDirection(), direction);
    }
}