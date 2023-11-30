package controllerTest;

import com.group11.controller.KeyboardInterpretor;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class KeyboardInterpretorTest {
    private Set<Integer> inputSet = new HashSet<>();
    
    @Test
    public void KeyWandAreturnsDir7(){
        inputSet.add(87);
        inputSet.add(65);

        assertEquals(KeyboardInterpretor.WASDToDir(inputSet), 7);
    }
    @Test
    public void KeyWandDreturnsDir1(){
        inputSet.add(87);
        inputSet.add(68);

        assertEquals(KeyboardInterpretor.WASDToDir(inputSet), 1);
    }
    @Test
    public void KeySandDreturnsDir3(){
        inputSet.add(83);
        inputSet.add(68);

        assertEquals(KeyboardInterpretor.WASDToDir(inputSet), 3);
    }
    @Test
    public void KeySandAreturnsDir5(){
        inputSet.add(83);
        inputSet.add(65);

        assertEquals(KeyboardInterpretor.WASDToDir(inputSet), 5);
    }
    @Test
    public void KeyWreturnsDir0(){
        inputSet.add(87);

        assertEquals(KeyboardInterpretor.WASDToDir(inputSet), 0);
    }
    @Test
    public void KeyDreturnsDir2(){
        inputSet.add(68);

        assertEquals(KeyboardInterpretor.WASDToDir(inputSet), 2);
    }
    @Test
    public void KeySreturnsDir4(){
        inputSet.add(83);

        assertEquals(KeyboardInterpretor.WASDToDir(inputSet), 4);
    }
    @Test
    public void KeyAreturnsDir6(){
        inputSet.add(65);

        assertEquals(KeyboardInterpretor.WASDToDir(inputSet), 6);
    }
    @Test
    public void WandAandSandDReturnsDirNegative1(){
        inputSet.add(38);
        inputSet.add(37);
        inputSet.add(40);
        inputSet.add(39);  

        assertEquals(KeyboardInterpretor.arrowsToDir(inputSet), -1);
    }


    @Test
    public void UpAndLeftReturnsDir7(){
        inputSet.add(38);
        inputSet.add(37);

        assertEquals(KeyboardInterpretor.arrowsToDir(inputSet), 7);
    }
    @Test
    public void UpAndRightReturnsDir1(){
        inputSet.add(38);
        inputSet.add(39);

        assertEquals(KeyboardInterpretor.arrowsToDir(inputSet), 1);
    }
    @Test
    public void DownAndLeftReturnsDir3(){
        inputSet.add(40);
        inputSet.add(39);

        assertEquals(KeyboardInterpretor.arrowsToDir(inputSet), 3);
    }
    @Test
    public void DownAndRightReturnsDir5(){
        inputSet.add(40);
        inputSet.add(37);

        assertEquals(KeyboardInterpretor.arrowsToDir(inputSet), 5);
    }
    @Test
    public void UpReturnsDir0(){
        inputSet.add(38);

        assertEquals(KeyboardInterpretor.arrowsToDir(inputSet), 0);
    }
    @Test
    public void RightReturnsDir2(){
        inputSet.add(39);

        assertEquals(KeyboardInterpretor.arrowsToDir(inputSet), 2);
    }
    @Test
    public void DownReturnsDir4(){
        inputSet.add(40);

        assertEquals(KeyboardInterpretor.arrowsToDir(inputSet), 4);
    }
    @Test
    public void UpAndRightAndLeftReturnsDir0(){
        inputSet.add(37);
        inputSet.add(38);
        inputSet.add(39);

        assertEquals(KeyboardInterpretor.arrowsToDir(inputSet), 0);
    }
    @Test
    public void UpAndRightAndLeftAndDownReturnsDirNegative1(){
        inputSet.add(38);
        inputSet.add(37);
        inputSet.add(40);
        inputSet.add(39);  

        assertEquals(KeyboardInterpretor.arrowsToDir(inputSet), -1);
    }

}