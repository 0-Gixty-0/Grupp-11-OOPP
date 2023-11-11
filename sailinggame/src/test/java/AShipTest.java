import org.junit.Test;

import com.group11.model.AShip;
import com.group11.model.LargeShip;
import com.group11.model.SmallShip;

import static org.junit.Assert.*;

public class AShipTest {

    LargeShip largeShip = new LargeShip(1,10,0, true);

    @Test
    public void testAnchor() {
        largeShip.anchorUp();
        assertEquals(largeShip.getAnchorStatus(), false);
        largeShip.anchorDown();
        assertEquals(largeShip.getAnchorStatus(), true);
        assertEquals(largeShip.getVelocity(), 0);
    }

    @Test
    public void testSail() {
        largeShip.raiseSail();
        assertEquals(largeShip.getSailStatus(), true);
        largeShip.lowerSail();
        assertEquals(largeShip.getSailStatus(),false);
    }
}