package com.cab.graph;

import lombok.Setter;

public class View implements IView{
    @Setter
    private IModel model;
    @Setter
    private IController controller;
}
