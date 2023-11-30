package modelTest;

import com.group11.model.*;
import org.junit.Test;

import static org.junit.Assert.*;


public class AProjectileTest {

    AProjectile testCannonBall = new BasicCannonBall();

    @Test
    public void testIsOutOfRange() {
        assertFalse(testCannonBall.isOutOfRange());
    }

    @Test
    public void testTravel() {
        testCannonBall.travel();
        assertEquals(testCannonBall.getDistanceTraveled(), 1);
    }

    @Test
    public void testGetDistanceTraveled() {
        assertEquals(testCannonBall.getDistanceTraveled(), 0);
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