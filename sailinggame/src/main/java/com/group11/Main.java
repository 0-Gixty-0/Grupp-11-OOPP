package com.group11;

import com.group11.view.AppWindow;

public class Main {
    private static AppWindow appWindow;
    private static int windowHeight;
    private static int windowWidth;

    public Main(int windowWidth, int windowHeight) {
        Main.windowHeight = windowHeight;
        Main.windowWidth = windowWidth;
        Main.appWindow = new AppWindow(windowWidth, windowHeight);
    }

    public void run() {
        Main.appWindow.drawGame();
    }

    public static void main(String[] args) {
        Main main = new Main(800,800);
        main.run();
    }
}