package com.cab.graph;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
public class Link<E> implements ILink<E> {
    private final INode<E> start;
    public final INode<E> end;

    @NonNull @Setter
    public int weight;

    public Link(@NonNull final INode<E> start,
                @NonNull final INode<E> end,
                final int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;

        this.start.addLink(this);
        this.end.addLink(this);
    }
}
