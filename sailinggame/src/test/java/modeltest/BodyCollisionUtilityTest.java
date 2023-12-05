package modeltest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.group11.model.gameentites.ABody;
import com.group11.model.gameentites.Ship;
import com.group11.model.utility.UBodyCollisionUtility;

public class BodyCollisionUtilityTest {

    private List<List<ABody>> bodies;
    private ABody testBody;
    private ABody testBody2;
    private Point pos;

    @Before
    public void setUp() {
        this.bodies = new ArrayList<>();
        this.pos = new Point(0, 0);
        Point pos2 = new Point(0,0);
        this.testBody = new Ship(pos, 0, 0, 0, 0);
        this.testBody2 = new Ship(pos2, 0, 0, 0, 0);
        this.bodies.add(new ArrayList<ABody>() {{
                add(testBody);
            }});
    }

    @Test
    public void testSetBodies() {
        UBodyCollisionUtility.setBodyMatrix(null);
        assertThrows(IllegalStateException.class, ()->UBodyCollisionUtility.isPositionOccupied(pos));
    }

    @Test
    public void testIsPositionOccupied() {
        UBodyCollisionUtility.setBodyMatrix(bodies);
        assertEquals(testBody, UBodyCollisionUtility.isPositionOccupied(pos));
    }

    @Test
    public void testIsBodyColliding() {
        UBodyCollisionUtility.setBodyMatrix(bodies);
       assertEquals(testBody, UBodyCollisionUtility.isBodyColliding(testBody2));;
    }
}