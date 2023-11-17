import org.junit.Test;

import com.group11.model.Ship;

import static org.junit.Assert.*;

import java.awt.*;

public class AMovableBodyTest {

    Point position = new Point(10,10);
    Ship testShip = new Ship(null, position, 0, 0, 0, 0, 2);

    @Test
    public void testMove() {
        testShip.move(20,20);
        Point secondPosition = new Point(20,20);
        assertEquals(testShip.getPos(), secondPosition);
    }

    @Test
    public void testVelocity() {
        testShip.setVelocity(10);
        int velocity = testShip.getVelocity();
        assertEquals(velocity, 10);
    }
}