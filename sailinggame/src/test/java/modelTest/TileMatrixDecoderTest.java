package modelTest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.group11.model.ATile;
import com.group11.model.BasicMapGenerator;
import com.group11.model.Map;
import com.group11.model.TileMatrixDecoder;

public class TileMatrixDecoderTest {

    @Test
    public void testDecodeIntoIntMatrix() {
        Map map = (new BasicMapGenerator()).generateMap(50);
        List<List<ATile>> tileMatrix = map.getTileMatrix();
        List<List<Integer>> gMap = TileMatrixDecoder.decodeIntoIntMatrix(tileMatrix);
        
        assertEquals(1, (int) gMap.get(0).get(0));
        assertEquals(0, (int) gMap.get(25).get(25));
    }
    
}