package modelTest;

import org.junit.Test;
import com.group11.model.*;
import static org.junit.Assert.*;

public class BasicWorldGeneratorTest {

    IMapGenerator mapGenerator = new BasicMapGenerator();
    World testWorld = new BasicWorldGenerator(mapGenerator).generateWorld(10);

    @Test
    public void testGenerateWorld() {
        assertSame(World.class, testWorld.getClass());
    }
}