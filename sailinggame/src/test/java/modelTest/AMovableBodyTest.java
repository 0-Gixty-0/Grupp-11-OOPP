package modelTest;

import org.junit.Test;

import com.group11.model.game_entites.Ship;

import static org.junit.Assert.*;
import java.awt.*;

public class AMovableBodyTest {

    Point position = new Point(10, 10);
    Ship testShip = new Ship(position, 0, 0, 0, 2);

    @Test
    public void testGetVelocity() {
        int velocity = testShip.getVelocity();
        assertEquals(velocity, 0);
    }
}