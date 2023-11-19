import org.junit.Test;

import com.group11.model.ATile;
import com.group11.model.BasicMapGenerator;
import com.group11.model.LandTile;
import com.group11.model.Map;

import static org.junit.Assert.*;

public class MapTest {

    @Test
    public void testGetArea() {
        Map map = (new BasicMapGenerator()).generateMap(100);
        assertEquals(map.getArea(), 10000);
    }

    @Test
    public void testGetTileMatrix() {
        Map map = (new BasicMapGenerator()).generateMap(100);
        ATile tile = map.getTileMatrix().get(50).get(50);
        assertSame(LandTile.class, tile.getClass());
    }

}
