import org.junit.Test;

import com.group11.model.AShip;
import com.group11.model.MedShip;
import com.group11.model.SmallShip;

import static org.junit.Assert.*;

import java.awt.*;

public class AMovableBodyTest {

    MedShip mediumShip = new MedShip(1,10,0, true);

    @Test
    public void testMove() {
        Point newPosition = new Point(10,10);
        mediumShip.setPos(newPosition);
        mediumShip.move(20,20);
        Point secondPosition = new Point(20,20);
        assertEquals(mediumShip.getPos(), secondPosition);
    }
}
