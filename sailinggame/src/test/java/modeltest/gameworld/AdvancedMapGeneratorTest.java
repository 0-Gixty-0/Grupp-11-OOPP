package modeltest.gameworld;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.group11.model.gameworld.AdvancedMapGenerator;
import com.group11.model.gameworld.Map;

public class AdvancedMapGeneratorTest {

    /**
     * Test the generateMap method of the BasicMapGenerator class.
     * This test checks that the method generates a map of the correct area.
     */
    @Test
    public void testGenerateMap() {
        // Create an instance of BasicMapGenerator
        AdvancedMapGenerator testMapGenerator = new AdvancedMapGenerator();

        // Generate a map with a side length of 10
        Map generatedMap = testMapGenerator.generateMap(10,10);

        // Check that the map has the correct area
        assertEquals(100, generatedMap.getArea());
    }
}