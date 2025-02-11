package com.cab;

import com.cab.graph.*;


public class Main {
    public static void main(String[] args) {
        IView view = new View();
        IModel model = new Model();
        IController controller = new Controller();

        controller.setModel(model);
        controller.setView(view);
    }
}