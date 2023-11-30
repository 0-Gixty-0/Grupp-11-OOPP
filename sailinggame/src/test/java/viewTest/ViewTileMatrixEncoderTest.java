package viewTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.group11.view.ViewTileMatrixEncoder;
import com.group11.view.uicomponents.AViewDrawable;

public class ViewTileMatrixEncoderTest {

    private List<List<Integer>> createIntMatrix(int tile1, int tile2) {
        List<List<Integer>> playerIntMatrix = new ArrayList<>(); // Spawning the player at (0,0)
        for (int i = 0; i < 50; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < 50; j++) {
                if (i == 0 && j == 0) {
                    row.add(tile1);
                } else {
                    row.add(tile2);
                }
            }
            playerIntMatrix.add(row);
        }
        return playerIntMatrix;
    }

    @Test
    public void testCreateEntityMatrix() {
        List<List<Integer>> playerIntMatrix = createIntMatrix(0, -1);
        List<List<AViewDrawable>> playerTileMatrix = ViewTileMatrixEncoder.createEntityTileMatrix(playerIntMatrix);
        AViewDrawable playerTile = playerTileMatrix.get(0).get(0);
        AViewDrawable emptyTile = playerTileMatrix.get(1).get(1);
        assertEquals("0", playerTile.getName());
        assertEquals("-1", emptyTile.getName());
        
    }

    @Test
    public void testCreateTerrainMatrix() {
        List<List<Integer>> playerIntMatrix = createIntMatrix(0, 1);
        List<List<AViewDrawable>> playerTileMatrix = ViewTileMatrixEncoder.createEntityTileMatrix(playerIntMatrix);
        AViewDrawable landTile = playerTileMatrix.get(0).get(0);
        AViewDrawable seaTile = playerTileMatrix.get(1).get(1);
        assertEquals("0", landTile.getName());
        assertEquals("1", seaTile.getName());
    }
}