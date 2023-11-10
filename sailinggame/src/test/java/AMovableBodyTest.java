import com.group11.Model.SmallShip;
import org.junit.Test;
import static org.junit.Assert.*;

import com.group11.Model.AShip;

import java.awt.*;

public class AMovableBodyTest {

    SmallShip smallship = new SmallShip(1,10,0, true);

    @Test
    public void testMove() {
        Point new_position = new Point(10,10);
        smallship.setPos(new_position);
        smallship.move(20,20);
        Point second_position = new Point(20,20);
        assertEquals(smallship.getPos(), second_position);
    }
}
