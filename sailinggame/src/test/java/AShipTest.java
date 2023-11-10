import com.group11.Model.SmallShip;
import org.junit.Test;
import static org.junit.Assert.*;

import com.group11.Model.AShip;

public class AShipTest {

    SmallShip smallship = new SmallShip(1,10,0, true);

    @Test
    public void testanchor() {
        smallship.anchorUp();
        assertEquals(smallship.getAnchorStatus(), false);
        smallship.anchorDown();
        assertEquals(smallship.getAnchorStatus(), true);
        assertEquals(smallship.getVelocity(), 0);
    }

    @Test
    public void testSail() {
        smallship.raiseSail();
        assertEquals(smallship.getSailStatus(), true);
        smallship.lowerSail();
        assertEquals(smallship.getSailStatus(),false);
    }
}