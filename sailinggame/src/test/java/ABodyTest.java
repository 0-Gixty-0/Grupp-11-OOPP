import org.junit.Test;

import com.group11.model.Ship;

import static org.junit.Assert.*;

import java.awt.*;

public class ABodyTest {

    Ship testShip = new Ship(null, null, 0, 0, 0, 0);

    @Test
    public void testTakeDamage() {
        testShip.setHitPoints(100);
        int testHitPoints = testShip.getHitPoints();
        assertEquals(testHitPoints, 100);
        testShip.takeDamage(75);
        testHitPoints = testShip.getHitPoints();
        assertEquals(testHitPoints, 25);
    }

    @Test
    public void testPosition() {
        Point testPosition = new Point(10, 20);
        testShip.setPos(testPosition);
        Point secondPosition = testShip.getPos();
        assertEquals(testPosition, secondPosition);
    }
}