package modeltest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.group11.model.gameworld.AdvancedMapGenerator;
import com.group11.model.gameworld.Map;

public class AdvancedMapGeneratorTest {

    /**
     * Test the generateMap method of the BasicMapGenerator class.
     * This test checks that the method generates a map of the correct area.
     */
    @Test
    void testGenerateMap() {
        AdvancedMapGenerator generator = new AdvancedMapGenerator();
        Map map = generator.generateMap(10, 10);
        
        // Check that the map is not null
        assertNotNull(map);
        
        // Check that the map has the correct dimensions
        assertEquals(10, map.getMapWidth());
        assertEquals(10, map.getMapHeight());
    }
}