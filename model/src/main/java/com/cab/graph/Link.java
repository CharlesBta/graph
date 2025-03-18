package com.cab.graph;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
public class Link<E> implements ILink<E> {
    public final INode<E> end;
    private final INode<E> start;
    @NonNull
    @Setter
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

    @Override
    public int compareTo(final ILink<E> other) {
        return Integer.compare(this.weight, other.getWeight());
    }
}
