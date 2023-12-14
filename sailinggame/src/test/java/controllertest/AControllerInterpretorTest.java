package controllertest;

import com.group11.controller.GlobalKeyListener;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class AControllerInterpretorTest {

    GlobalKeyListener globalKeyListener = new GlobalKeyListener();

    @Test
    public void getInputTest() {
        Set<Integer> testSet = globalKeyListener.getInput();

        assert(testSet instanceof HashSet);
    }
}