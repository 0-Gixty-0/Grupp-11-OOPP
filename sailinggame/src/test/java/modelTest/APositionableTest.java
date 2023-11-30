package modelTest;

import org.junit.Test;

import com.group11.model.gameentites.Ship;

import static org.junit.Assert.*;
import java.awt.*;

public class APositionableTest {

    Point testPosition = new Point(10, 20);
    Ship testShip = new Ship(testPosition, 0, 0, 0, 100);

    @Test
    public void getPosTest() {
        assertEquals(testPosition, testShip.getPos());
    }

    @Test
    public void getTruePosTest() {
        // Can't test this method since It's protected.
    }
}