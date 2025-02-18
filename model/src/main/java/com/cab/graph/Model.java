package com.cab.graph;

public class Model implements IModel{
    private final IGraph<String> graph = new StringGraph();

    public Model(){
        graph.loadFromJson("AventuriersDuRailEurope.json");
    }
}
