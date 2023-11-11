import com.group11.view.AbstractViewTile;
import com.group11.view.ViewTile;
import org.junit.Test;
import static org.junit.Assert.*;

import java.awt.*;

public class AbstractViewTileTest {
    // Wanted to test this method which is private since it is important that it functions.
    // To run this test first make getTextureMatrixCoordinate public
//    @Test
//    public void testGetTextureMatrixCoordinate() {
//        AbstractViewTile tile = new ViewTile(0, new Dimension(16,16), new Point(0,0), new Point(0,0));
//        assertEquals(new Point(0,0), tile.getTextureMatrixCoordinate(0));
//        assertEquals(new Point(0,3), tile.getTextureMatrixCoordinate(3));
//        assertEquals(new Point(1,1), tile.getTextureMatrixCoordinate(5));
//        assertEquals(new Point(2,0), tile.getTextureMatrixCoordinate(8));
//        assertEquals(new Point(3,2), tile.getTextureMatrixCoordinate(14));
//        assertEquals(new Point(1,0), tile.getTextureMatrixCoordinate(4));
//    }

    @Test
    public void constructorThrowsIllegalArgumentExceptionLowID() {
        assertThrows(IllegalArgumentException.class, () -> new ViewTile(-1, new Dimension(16,16), new Point(0,0), new Point(0,0)));
    }

    @Test
    public void constructorThrowsIllegalArgumentExceptionHighID() {
        assertThrows(IllegalArgumentException.class, () -> new ViewTile(16, new Dimension(16,16), new Point(0,0), new Point(0,0)));
    }
}
