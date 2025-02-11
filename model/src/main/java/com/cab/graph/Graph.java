package com.cab.graph;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Graph<E> implements IGraph<E> {
    private final List<INode<E>> nodes = new ArrayList<>();

    @Override
    public void addNode(@NonNull final INode<E> node) {
        if (!this.nodes.contains(node)) {
            this.nodes.add(node);
        }
    }

    @Override
    public void loadFromJson(final @NonNull Gson json) {

    }

    @Override
    public String toJson() {
        return "";
    }
}
