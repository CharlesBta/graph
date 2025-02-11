package com.cab.graph;

public interface ILink<E> {
    INode<E> getStart();
    INode<E> getEnd();

    int getWeight();
    void setWeight(final int weight);
}
