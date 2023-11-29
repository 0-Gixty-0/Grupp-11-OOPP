package modelTest;

import com.group11.model.*;
import com.group11.model.game_entites.CommandableEntity;
import com.group11.model.game_entites.Ship;

import org.junit.Test;

import static org.junit.Assert.*;

import java.awt.*;

public class AEntityTest {

    Point testPosition = new Point(10, 20);
    Ship testShip = new Ship(testPosition, 0, 0, 0, 100);

    CommandableEntity testBody = new CommandableEntity(testShip, "Ship", true);

    @Test
    public void testGetName() {
        assertEquals("Ship", testBody.getName());
    }
}