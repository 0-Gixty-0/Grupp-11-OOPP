package modeltest;

import static org.junit.Assert.assertEquals;

import java.awt.Point;

import org.junit.Test;

import com.group11.model.gameentites.CommandableEntity;
import com.group11.model.gameentites.Ship;

public class AEntityTest {

    Point testPosition = new Point(10, 20);
    Ship testShip = new Ship(testPosition, 0, 0, 0, 100);

    CommandableEntity testBody = new CommandableEntity(testShip, "Ship", true);

    @Test
    public void testGetName() {
        assertEquals("Ship", testBody.getName());
    }
}