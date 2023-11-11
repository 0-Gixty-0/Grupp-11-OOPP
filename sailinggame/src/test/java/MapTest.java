import org.junit.Test;

import com.group11.model.ATile;
import com.group11.model.BasicMapGenerator;
import com.group11.model.Map;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class MapTest {

    @Test
    public void testGetGraphicMatrix() {
        Map map = (new BasicMapGenerator()).generateMap(100);
        ArrayList<ArrayList<Integer>> graphicMatrix = map.getGraphicMatrix();
        assertEquals(graphicMatrix.size(), 100);
    }

    @Test
    public void testGetArea() {
        Map map = (new BasicMapGenerator()).generateMap(100);
        assertEquals(map.getArea(), 10000);
    }

    @Test
    public void testGetTileMatrix() {
        Map map = (new BasicMapGenerator()).generateMap(100);
        ATile tile = map.getTileMatrix().get(50).get(50);
        assertSame(ATile.class, tile.getClass());
    }

}
