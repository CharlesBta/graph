package com.cab.graph;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Node<E> implements INode<E> {
    private final List<ILink<E>> links = new ArrayList<>();

    @Setter
    private E value;

    public Node(final E value) {
        this.value = value;
    }

    @Override
    public void addLink(final @NonNull ILink<E> link) {
        if (!this.links.contains(link)) {
            this.links.add(link);
        }
    }

    @Override
    public String toString() {
        return this.getValue().toString();
    }
}
