package modeltest.utility;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.group11.model.gameworld.ATile;
import com.group11.model.gameworld.BasicMapGenerator;
import com.group11.model.gameworld.Map;
import com.group11.model.utility.UTileMatrixDecoder;

public class UTileMatrixDecoderTest {

    @Test
    public void testDecodeIntoIntMatrix() {
        Map map = (new BasicMapGenerator()).generateMap(50,50);
        List<List<ATile>> tileMatrix = map.getTileMatrix();
        UTileMatrixDecoder.setTilematrix(tileMatrix);
        List<List<Integer>> gMap = UTileMatrixDecoder.decodeIntoIntMatrix();
        
        assertEquals(1, (int) gMap.get(0).get(0));
        assertEquals(0, (int) gMap.get(25).get(25));
    }
    
}