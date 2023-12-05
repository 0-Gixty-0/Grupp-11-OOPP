package applicationtest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

import com.group11.application.ScoreBoard;
import com.group11.model.gameentites.AEntity;
import com.group11.model.gameentites.CommandableEntity;

public class ScoreBoardTest {
    
    @Before
    public void setUp() {
        ScoreBoard.clearScoreBoard();
    }

    @Test
    public void testAddEntityToScoreBoard() {
        ScoreBoard.addEntityToScoreBoard("testEntity");
        AEntity testEntity = new CommandableEntity(null, "Test", true);
        ScoreBoard.addEntityToScoreBoard(testEntity);
        assertEquals( 0, ScoreBoard.getScore("testEntity"));
        assertEquals( 0, ScoreBoard.getScore(testEntity));
    }

    @Test
    public void testRemoveFromScoreBoard() {
        ScoreBoard.addEntityToScoreBoard("testEntity");
        assertEquals(0, ScoreBoard.getScore("testEntity"));
        ScoreBoard.removeFromScoreBoard("testEntity");
        assertThrows(NullPointerException.class, () -> ScoreBoard.getScore("testEntity"));
    }

    @Test
    public void testIncrementScore() {
        ScoreBoard.addEntityToScoreBoard("testEntity");
        ScoreBoard.incrementScore("testEntity", 5);
        assertEquals(5, ScoreBoard.getScore("testEntity"));
        ScoreBoard.incrementScore("testEntity", 5);
        assertEquals(10, ScoreBoard.getScore("testEntity"));
    }

    @Test
    public void testGetScore() {
        ScoreBoard.addEntityToScoreBoard("testEntity");
        assertEquals(0, ScoreBoard.getScore("testEntity"));
        ScoreBoard.incrementScore("testEntity", 5);
        assertEquals(5, ScoreBoard.getScore("testEntity"));
    }

    @Test
    public void testSetScore() {
        ScoreBoard.addEntityToScoreBoard("testEntity");
        assertEquals(0, ScoreBoard.getScore("testEntity"));
        ScoreBoard.setScore("testEntity", 5);
        assertEquals(5, ScoreBoard.getScore("testEntity"));
    }

    @Test
    public void testClearScoreBoard() {
        ScoreBoard.addEntityToScoreBoard("testEntity");
        ScoreBoard.addEntityToScoreBoard("testEntity2");
        ScoreBoard.addEntityToScoreBoard("testEntity3");
        ScoreBoard.clearScoreBoard();
        assertThrows(NullPointerException.class, () -> ScoreBoard.getScore("testEntity"));
        assertThrows(NullPointerException.class, () -> ScoreBoard.getScore("testEntity2"));
        assertThrows(NullPointerException.class, () -> ScoreBoard.getScore("testEntity3"));
    }

}
