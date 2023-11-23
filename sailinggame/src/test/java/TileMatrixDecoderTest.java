import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.group11.model.ATile;
import com.group11.model.BasicMapGenerator;
import com.group11.model.Map;
import com.group11.model.TileMatrixDecoder;

public class TileMatrixDecoderTest {

    @Test
    public void testDecodeIntoIntMatrix() {
        Map map = (new BasicMapGenerator()).generateMap(50);
        ArrayList<ArrayList<ATile>> tileMatrix = map.getTileMatrix();
        ArrayList<ArrayList<Integer>> gMap = TileMatrixDecoder.decodeIntoIntMatrix(tileMatrix);
        
        assertEquals(0, (int) gMap.get(0).get(0));
        assertEquals(1, (int) gMap.get(25).get(25));
    }
    
}
