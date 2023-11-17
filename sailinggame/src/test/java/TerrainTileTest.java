import com.group11.view.TerrainTile;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertThrows;

public class TerrainTileTest {
    @Test
    public void constructorThrowsIllegalArgumentExceptionLowID() {
        assertThrows(IllegalArgumentException.class, () -> new TerrainTile(-1, new Dimension(16,16), new Point(0,0), new Point(0,0)));
    }

    @Test
    public void constructorThrowsIllegalArgumentExceptionHighID() {
        assertThrows(IllegalArgumentException.class, () -> new TerrainTile(16, new Dimension(16,16), new Point(0,0), new Point(0,0)));
    }
}
