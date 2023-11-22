import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.group11.model.ABody;
import com.group11.model.BodyCollisionUtility;
import com.group11.model.Ship;

public class BodyCollisionUtilityTest {

    private ArrayList<ArrayList<ABody>> bodies;
    private ABody testBody;
    private ABody testBody2;
    private Point pos;

    @Before
    public void setUp() {
        this.bodies = new ArrayList<>();
        this.pos = new Point(0, 0);
        Point pos2 = new Point(0,0);
        this.testBody = new Ship(null, pos, 0, 0, 0, 0);
        this.testBody2 = new Ship(null, pos2, 0, 0, 0, 0);
        this.bodies.add(new ArrayList<ABody>() {{
                add(testBody);
            }});
    }

    @Test
    public void testSetBodies() {
        BodyCollisionUtility.setBodies(null);
        assertThrows(IllegalStateException.class, ()->BodyCollisionUtility.isPositionOccupied(pos));
    }

    @Test
    public void testIsPositionOccupied() {
        BodyCollisionUtility.setBodies(bodies);
        assertEquals(testBody, BodyCollisionUtility.isPositionOccupied(pos));
    }

    @Test
    public void testIsBodyColliding() {
        BodyCollisionUtility.setBodies(bodies);
       assertEquals(testBody, BodyCollisionUtility.isBodyColliding(testBody2));;
    }

}