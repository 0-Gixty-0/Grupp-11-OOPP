import org.junit.Test;

import com.group11.model.Ship;

import static org.junit.Assert.*;

import java.awt.*;

public class AMovableBodyTest {

    Ship testShip = new Ship(1,10,0, true);

    @Test
    public void testMove() {
        Point newPosition = new Point(10,10);
        testShip.setPos(newPosition);
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
