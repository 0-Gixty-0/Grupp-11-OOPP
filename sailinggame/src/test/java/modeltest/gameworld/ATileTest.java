package modeltest.gameworld;

import org.junit.Test;

import com.group11.model.gameworld.ATile;

import java.awt.Point;

import static org.junit.Assert.*;

public class ATileTest {

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
        assertFalse(isPassable2);
    }

    // ConcreteATile is a concrete subclass of ATile for testing purposes                                                                                                                     
    private static class ConcreteATile extends ATile {
        public ConcreteATile(int textureId, Point pos, Boolean passable) {
            super(textureId, pos, passable);
        }
    }
}