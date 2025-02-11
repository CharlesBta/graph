package com.cab.graph;

import com.google.gson.Gson;
import lombok.NonNull;

import java.util.List;

public interface IGraph<E> {
    List<INode<E>> getNodes();
    void addNode(@NonNull final INode<E> node);

    void loadFromJson(@NonNull final Gson json);
    Gson toJson();
}
