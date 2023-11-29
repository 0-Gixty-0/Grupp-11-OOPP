package modelTest;

import org.junit.Test;

import com.group11.model.*;
import com.group11.model.gameWorld.BasicMapGenerator;
import com.group11.model.gameWorld.Map;

import static org.junit.Assert.*;

public class BasicMapGeneratorTest {

    /**
     * Test the generateMap method of the BasicMapGenerator class.
     * This test checks that the method generates a map of the correct area.
     */
    @Test
    public void testGenerateMap() {
        // Create an instance of BasicMapGenerator
        BasicMapGenerator testMapGenerator = new BasicMapGenerator();

        // Generate a map with a side length of 10
        Map generatedMap = testMapGenerator.generateMap(10);

        // Check that the map has the correct area
        assertEquals(100, generatedMap.getArea());
    }
}