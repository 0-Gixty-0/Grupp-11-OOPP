import org.junit.Test;

import com.group11.Model.AMapGenerator;
import com.group11.Model.BasicMapGenerator;
import com.group11.Model.BasicWorldGenerator;
import com.group11.Model.Map;
import com.group11.Model.World;

import static org.junit.Assert.*;

public class WorldTest {
    
    @Test
    public void testGetMap() {
        AMapGenerator basicMapGenerator = new BasicMapGenerator();
        World world = (new BasicWorldGenerator(basicMapGenerator)).generateWorld(100);
        assertSame(Map.class, world.getMap().getClass());
    }

    @Test
    public void testSetMap() {
        AMapGenerator basicMapGenerator = new BasicMapGenerator();
        World world = (new BasicWorldGenerator(basicMapGenerator)).generateWorld(100);
        Map oldMap = world.getMap();
        Map newMap = basicMapGenerator.generateMap(100);
        world.setMap(newMap);
        assertNotEquals(oldMap, world.getMap());
    }
}
