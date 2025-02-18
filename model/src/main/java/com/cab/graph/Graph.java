package com.cab.graph;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.NonNull;

import java.net.URL;
import java.nio.file.FileSystemNotFoundException;
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
    public void loadFromJson(final @NonNull String jsonFileName) {
        final URL url =  this.getClass().getClassLoader().getResource(jsonFileName);
        if (url == null) {
            throw new FileSystemNotFoundException("File not found: " + jsonFileName);
        }
        final StringBuilder jsonString = new StringBuilder();

    }

    @Override
    public Gson toJson() {
        return null;
    }
}
