package controllertest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.group11.controller.KeyboardInterpretor;

public class KeyboardInterpretorTest {
    
    private KeyboardInterpretor keyboardInterpretor = new KeyboardInterpretor();

    @Test
    public void KeyWandAreturnsDir7(){
        keyboardInterpretor.getInputSet().add(87);
        keyboardInterpretor.getInputSet().add(65);

        assertEquals(7, keyboardInterpretor.getMovementInput());
    }
    @Test
    public void KeyWandDreturnsDir1(){
        keyboardInterpretor.getInputSet().add(87);
        keyboardInterpretor.getInputSet().add(68);

        assertEquals(1, keyboardInterpretor.getMovementInput());
    }
    @Test
    public void KeySandDreturnsDir3(){
        keyboardInterpretor.getInputSet().add(83);
        keyboardInterpretor.getInputSet().add(68);

        assertEquals(3, keyboardInterpretor.getMovementInput());
    }
    @Test
    public void KeySandAreturnsDir5(){
        keyboardInterpretor.getInputSet().add(83);
        keyboardInterpretor.getInputSet().add(65);

        assertEquals(5, keyboardInterpretor.getMovementInput());
    }
    @Test
    public void KeyWreturnsDir0(){
        keyboardInterpretor.getInputSet().add(87);

        assertEquals(0, keyboardInterpretor.getMovementInput());
    }
    @Test
    public void KeyDreturnsDir2(){
        keyboardInterpretor.getInputSet().add(68);

        assertEquals(2, keyboardInterpretor.getMovementInput());
    }
    @Test
    public void KeySreturnsDir4(){
        keyboardInterpretor.getInputSet().add(83);

        assertEquals(4, keyboardInterpretor.getMovementInput());
    }
    @Test
    public void KeyAreturnsDir6(){
        keyboardInterpretor.getInputSet().add(65);

        assertEquals(6, keyboardInterpretor.getMovementInput());
    }
    @Test
    public void WandAandSandDReturnsDirNegative1(){
        keyboardInterpretor.getInputSet().add(87);
        keyboardInterpretor.getInputSet().add(65);
        keyboardInterpretor.getInputSet().add(83);
        keyboardInterpretor.getInputSet().add(68);

        assertEquals(keyboardInterpretor.getMovementInput(), -1);
    }


    @Test
    public void UpAndLeftReturnsDir7(){
        keyboardInterpretor.getInputSet().add(38);
        keyboardInterpretor.getInputSet().add(37);
    
        assertEquals(7, keyboardInterpretor.getFireInput());
    }
    @Test
    public void UpAndRightReturnsDir1(){
        keyboardInterpretor.getInputSet().add(38);
        keyboardInterpretor.getInputSet().add(39);

        assertEquals(1, keyboardInterpretor.getFireInput());
    }
    @Test
    public void DownAndLeftReturnsDir3(){
        keyboardInterpretor.getInputSet().add(40);
        keyboardInterpretor.getInputSet().add(37);

        assertEquals(5, keyboardInterpretor.getFireInput());
    }
    @Test
    public void DownAndRightReturnsDir5(){
        keyboardInterpretor.getInputSet().add(40);
        keyboardInterpretor.getInputSet().add(39);

        assertEquals(3, keyboardInterpretor.getFireInput());
    }
    @Test
    public void UpReturnsDir0(){
        keyboardInterpretor.getInputSet().add(38);

        assertEquals(0, keyboardInterpretor.getFireInput());
    }
    @Test
    public void RightReturnsDir2(){
        keyboardInterpretor.getInputSet().add(39);

        assertEquals(2, keyboardInterpretor.getFireInput());
    }
    @Test
    public void DownReturnsDir4(){
        keyboardInterpretor.getInputSet().add(40);

        assertEquals(4, keyboardInterpretor.getFireInput());
    }
    @Test
    public void UpAndRightAndLeftReturnsDir0(){
        keyboardInterpretor.getInputSet().add(38);
        keyboardInterpretor.getInputSet().add(37);
        keyboardInterpretor.getInputSet().add(39);

        assertEquals(0, keyboardInterpretor.getFireInput());
    }
    @Test
    public void UpAndRightAndLeftAndDownReturnsDirNegative1(){
        keyboardInterpretor.getInputSet().add(38);
        keyboardInterpretor.getInputSet().add(37);
        keyboardInterpretor.getInputSet().add(39);
        keyboardInterpretor.getInputSet().add(40);

        assertEquals(keyboardInterpretor.getFireInput(), -1);
    }

}