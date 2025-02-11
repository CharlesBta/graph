package com.cab.graph;

import lombok.NonNull;
import lombok.Setter;


public class Controller implements IController{
    @NonNull @Setter
    private IModel model;
    private IView view;

    @Override
    public void setView(@NonNull final IView view) {
        this.view = view;
        this.view.setController(this);
    }
}
