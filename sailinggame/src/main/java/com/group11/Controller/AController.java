package com.group11.Controller;
import java.util.HashSet;
import java.util.Set;

import javax.swing.*;
import javax.tools.JavaCompiler;


abstract public class AController extends JComponent{

    AController(){
        super();
    }

    abstract
    Set<Integer>getInput();

}

