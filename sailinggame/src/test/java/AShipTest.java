import com.group11.Model.LargeShip;
import com.group11.Model.SmallShip;
import org.junit.Test;
import static org.junit.Assert.*;

import com.group11.Model.AShip;

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