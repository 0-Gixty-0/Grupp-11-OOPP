package controllertest;

import com.group11.controller.GlobalKeyListener;
import org.junit.Test;

import static org.junit.Assert.*;

public class GlobalKeyListenerTest {

    @Test
    public void getInputTest() {

        GlobalKeyListener testListener = new GlobalKeyListener();

        assertNotNull(testListener.getInput());
    }
}