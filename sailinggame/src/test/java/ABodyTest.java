import org.junit.Test;

import com.group11.model.Ship;

import static org.junit.Assert.*;

import java.awt.*;

public class ABodyTest {

    Point testPosition = new Point(10, 20);
    Ship testShip = new Ship(null, testPosition, 0, 0, 0, 2); 

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
        Point pos = testShip.getPos();
        assertEquals(pos, new Point(10,20));
    }
}