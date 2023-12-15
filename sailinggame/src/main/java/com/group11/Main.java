package com.group11;

import com.group11.application.AApplication;
import com.group11.application.SailingGameApplication;

class Main {

    public static void main(String[] args) throws InterruptedException {
        // the proportion between window size and map size needs to be equal, application works when it isn't, but it looks weird.
        AApplication app = new SailingGameApplication();
        app.run(60);
    }
}