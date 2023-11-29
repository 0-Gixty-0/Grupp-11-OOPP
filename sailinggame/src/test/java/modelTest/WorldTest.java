package modelTest;

import org.junit.Test;

import com.group11.model.gameWorld.BasicMapGenerator;
import com.group11.model.gameWorld.BasicWorldGenerator;
import com.group11.model.gameWorld.IMapGenerator;
import com.group11.model.gameWorld.Map;
import com.group11.model.gameWorld.World;

import static org.junit.Assert.*;

public class WorldTest {
    
    @Test
    public void testGetMap() {
        IMapGenerator basicMapGenerator = new BasicMapGenerator();
        World world = (new BasicWorldGenerator(basicMapGenerator)).generateWorld(100);
        assertSame(Map.class, world.getMap().getClass());
    }

    @Test
    public void testSetMap() {
        IMapGenerator basicMapGenerator = new BasicMapGenerator();
        World world = (new BasicWorldGenerator(basicMapGenerator)).generateWorld(100);
        Map oldMap = world.getMap();
        Map newMap = basicMapGenerator.generateMap(100);
        world.setMap(newMap);
        assertNotEquals(oldMap, world.getMap());
    }
}