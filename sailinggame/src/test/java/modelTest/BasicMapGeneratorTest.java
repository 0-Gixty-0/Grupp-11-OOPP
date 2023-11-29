package modelTest;

import org.junit.Test;

import com.group11.model.*;

import static org.junit.Assert.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BasicMapGeneratorTest {

    private static class TestTile extends ATile {
        public TestTile(Point pos) {
            super(0, pos, true);
        }
    }
    ATile testTile = new TestTile(new Point(0,0));

    List<List<ATile>> testTileMatrix = new ArrayList<>();

    private static class TestMap extends Map {
        public TestMap(List<List<ATile>> tileMatrix, int side) {
            super(tileMatrix, side);
        }
    }

    Map testMap = new TestMap(testTileMatrix, 10);

    @Test
    public void testGenerateMap() {
        BasicMapGenerator testMapGenerator = new BasicMapGenerator();
        Map generatedMap = testMapGenerator.generateMap(10);
        assertEquals(generatedMap.getArea(), testMap.getArea());
    }
}