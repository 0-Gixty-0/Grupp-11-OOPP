package modeltest;

import com.group11.model.utility.UAStar;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class AStarTest {
    private List<List<Integer>> grid = new ArrayList<>();
    @Before
    public void beforePreconditions() {
        this.grid.add(Arrays.asList(1,1,0,1,1));
        this.grid.add(Arrays.asList(1,0,1,0,1));
        this.grid.add(Arrays.asList(1,1,1,1,1));
        this.grid.add(Arrays.asList(1,0,1,0,1));
        this.grid.add(Arrays.asList(1,1,0,1,1));
    }
    @Test
    public void testUpDirectionReturned() {
        assertEquals(0, UAStar.aStar(this.grid, 2, 2, 1, 2));
    }

    @Test
    public void testTopRightDirectionReturned() {
        assertEquals(1, UAStar.aStar(this.grid, 3, 2, 1, 4));
    }

    @Test
    public void testRightDirectionReturned() {
        assertEquals(2, UAStar.aStar(this.grid, 2, 2, 2, 4));
    }

    @Test
    public void testBottomRightDirectionReturned() {
        assertEquals(3, UAStar.aStar(this.grid, 1, 2, 3, 4));
    }

    @Test
    public void testDownDirectionReturned() {
        assertEquals(4, UAStar.aStar(this.grid, 1, 2, 3, 2));
    }

    @Test
    public void testBottomLeftDirectionReturned() {
        assertEquals(5, UAStar.aStar(this.grid, 0, 3, 3, 0));
    }

    @Test
    public void testLeftDirectionReturned() {
        assertEquals(6, UAStar.aStar(this.grid, 2, 4, 2, 0));
    }

    @Test
    public void testTopLeftDirectionReturned() {
        assertEquals(7, UAStar.aStar(this.grid, 3, 4, 2, 0));
    }
}
