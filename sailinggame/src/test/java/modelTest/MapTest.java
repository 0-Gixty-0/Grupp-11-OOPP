package modelTest;

import org.junit.Test;

import com.group11.model.gameworld.ATile;
import com.group11.model.gameworld.BasicMapGenerator;
import com.group11.model.gameworld.LandTile;
import com.group11.model.gameworld.Map;

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