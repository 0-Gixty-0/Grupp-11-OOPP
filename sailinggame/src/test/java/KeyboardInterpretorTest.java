import com.group11.controller.keyboardInterpretor;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class KeyboardInterpretorTest {
    private Set<Integer> inputSet = new HashSet<>();
    
    @Test
    public void KeyWandAreturnsDir7(){
        inputSet.add((int) 'w');
        inputSet.add((int) 'a');

        assertEquals(keyboardInterpretor.inputToDir(inputSet), 7);
    }
    @Test
    public void KeyWandDreturnsDir1(){
        inputSet.add((int) 'w');
        inputSet.add((int) 'd');

        assertEquals(keyboardInterpretor.inputToDir(inputSet), 1);
    }
    @Test
    public void KeySandDreturnsDir3(){
        inputSet.add((int) 's');
        inputSet.add((int) 'd');

        assertEquals(keyboardInterpretor.inputToDir(inputSet), 3);
    }
    @Test
    public void KeySandAreturnsDir5(){
        inputSet.add((int) 's');
        inputSet.add((int) 'a');

        assertEquals(keyboardInterpretor.inputToDir(inputSet), 5);
    }
    @Test
    public void KeyWreturnsDir0(){
        inputSet.add((int) 'w');

        assertEquals(keyboardInterpretor.inputToDir(inputSet), 0);
    }
    @Test
    public void KeyDreturnsDir2(){
        inputSet.add((int) 'd');

        assertEquals(keyboardInterpretor.inputToDir(inputSet), 2);
    }
    @Test
    public void KeySreturnsDir4(){
        inputSet.add((int) 's');

        assertEquals(keyboardInterpretor.inputToDir(inputSet), 4);
    }
    @Test
    public void KeyAreturnsDir6(){
        inputSet.add((int) 'a');

        assertEquals(keyboardInterpretor.inputToDir(inputSet), 6);
    }
}
