import com.group11.Model.MediumShip;
import com.group11.Model.SmallShip;
import org.junit.Test;
import static org.junit.Assert.*;

import com.group11.Model.AShip;

import java.awt.*;

public class AMovableBodyTest {

    MediumShip mediumShip = new MediumShip(1,10,0, true);

    @Test
    public void testMove() {
        Point newPosition = new Point(10,10);
        mediumShip.setPos(newPosition);
        mediumShip.move(20,20);
        Point secondPosition = new Point(20,20);
        assertEquals(mediumShip.getPos(), secondPosition);
    }
}