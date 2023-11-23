import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.group11.model.ATile;

import java.awt.Point;

public class ATileTest {

    @Test
    public void testGetPos() {
        // Arrange
        Point expectedPos = new Point(3, 4);
        ATile tile = new ConcreteATile(1, expectedPos, true);

        // Act
        Point actualPos = tile.getPos();

        // Assert
        assertEquals(expectedPos, actualPos);
    }

    @Test
    public void testIsPassable() {
        // Arrange
        ATile passableTile = new ConcreteATile(2, new Point(1, 1), true);
        ATile nonPassableTile = new ConcreteATile(3, new Point(2, 2), false);

        // Act
        boolean isPassable1 = passableTile.isPassable();
        boolean isPassable2 = nonPassableTile.isPassable();

        // Assert
        assertTrue(isPassable1);
        assertTrue(!isPassable2);
    }

    // ConcreteATile is a concrete subclass of ATile for testing purposes
    private static class ConcreteATile extends ATile {
        public ConcreteATile(int textureId, Point pos, Boolean passable) {
            super(textureId, pos, passable);
        }
    }
}
