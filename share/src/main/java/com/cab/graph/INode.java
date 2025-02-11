package com.cab.graph;

import lombok.NonNull;

import java.util.List;

public interface INode<E> {
    E getValue();
    void setValue(final E value);

    List<ILink<E>> getLinks();
    void addLink(@NonNull final ILink<E> link);
}
