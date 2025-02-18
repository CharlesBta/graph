package com.cab.graph;

public class Model implements IModel{
    private final IGraph<INode<String>> graph = new Graph<>();

    public Model(){
        graph.loadFromJson("AventuriersDuRailEurope.json");
    }
}
