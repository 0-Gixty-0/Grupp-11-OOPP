package modelTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.group11.model.gameEntities.ABody;
import com.group11.model.gameEntities.Ship;
import com.group11.model.highLevelComponents.BodyCollisionUtility;

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
        this.testBody = new Ship(pos, 0, 0, 0, 0);
        this.testBody2 = new Ship(pos2, 0, 0, 0, 0);
        this.bodies.add(new ArrayList<ABody>() {{
                add(testBody);
            }});
    }

    @Test
    public void testSetBodies() {
        BodyCollisionUtility.setBodyMatrix(null);
        assertThrows(IllegalStateException.class, ()->BodyCollisionUtility.isPositionOccupied(pos));
    }

    @Test
    public void testIsPositionOccupied() {
        BodyCollisionUtility.setBodyMatrix(bodies);
        assertEquals(testBody, BodyCollisionUtility.isPositionOccupied(pos));
    }

    @Test
    public void testIsBodyColliding() {
        BodyCollisionUtility.setBodyMatrix(bodies);
       assertEquals(testBody, BodyCollisionUtility.isBodyColliding(testBody2));;
    }
}